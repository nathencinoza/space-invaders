package game;

public class SpaceInvadersGame {
	public static final int FPS = 60;
	public static final long MS_PER_FRAME = 1000 / FPS; 
	private AlienArmy alienArmy; 
	private Player player;
	private int score = 0;
	private long msSinceLastFrame = 0;
	
	//Constructor
	public SpaceInvadersGame() {
		this.alienArmy = new AlienArmy(); 
		this.player = new Player(); 
		this.score = 0;
	}
	
	//Verifica si el juego se terminó
	public boolean gameOver() {
		return (this.player.playerLives() == 0 || this.alienArmy.positionLastRowAliens() >= 405); 
	}
	
	//Actualiza el juego
	public boolean update(Iterable<Action> movements, long dt) {
		if (this.gameOver()) return false;

		for (Action movement : movements)
			movement.apply(this.player);
  	
		// dt is in nanoseconds
		this.msSinceLastFrame  = dt / 300_000;
		this.alienArmy.makeRandomAlienShoot();
		this.alienArmy.alienBullet().update();
		if(this.getPlayer().hasBeenShot(this.alienArmy.alienBullet().bulletXPosition(), this.alienArmy.alienBullet().bulletYPosition())) {
			this.alienArmy.alienBullet().setBulletInvisible();
		}
		while (this.msSinceLastFrame >= MS_PER_FRAME) {
			msSinceLastFrame -= MS_PER_FRAME;
			this.player.playerBullet().update();
	    	if (this.alienArmy.removeShotAliens(this.player.playerBullet().bulletXPosition(), this.player.playerBullet().bulletYPosition())) {
	    		this.score += Constants.PLAYER_POINTS;
	    		this.player.playerBullet().setBulletInvisible();
	    		
	    }
	    	
		}
		this.alienArmy.moveAliens();
		return true;
	}
  
	//Getters del puntaje, el jugador y el el ejercito de alienigenas para que los pueda usar en la interfaz gráfica
	   
	public int getScore() {
		return this.score;
	}
  	
	public Player getPlayer() {
		return this.player; 
	}
	
	public AlienArmy getAlienArmy() {
		return this.alienArmy; 
	}
	
}
