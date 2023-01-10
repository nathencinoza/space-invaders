package game;

public class Player {

	private int x_coordenate;
    private int lives; 
    private PlayerBullet bullet;
    
    //Constructor
    public Player() {
    	this.x_coordenate = Constants.PLAYER_START_POSITION; 
    	this.lives = Constants.PLAYER_LIVES; 
    	this.bullet = new PlayerBullet();
   }

  
    //Verifica si el jugador ha sido disparado, en caso de que haya sido disparado le quita una vida
    public boolean hasBeenShot(int x_bullet_coordenate, int y_bullet_coordenate) {
    	if ((x_bullet_coordenate >= this.x_coordenate) && (x_bullet_coordenate <= this.x_coordenate + Constants.PLAYER_WIDTH))  {
    		if ((y_bullet_coordenate > Constants.SCREEN_HEIGHT - Constants.PLAYER_HEIGHT)) {
    			this.lives -= 1; 
    			return true;
    		}
    	}
    	return false; 
    }
    //Devuelve la cantidad de vidas que tiene el jugador
    public int playerLives() {
    	return this.lives;
    }
    
    //Cambia la posición del jugador 
    public void playerSetPosition(int position){
    	this.x_coordenate = position; 
    }
       
    //Devuelve la posicion del jugador 
    public int playerPosition() {
    	return this.x_coordenate;
    }
    
    //Hace que dispare la bala del jugador
    public void shoot() {
    	this.bullet.shoot(this.x_coordenate);
    }
    
    //Devuelve la bala del jugador
    public PlayerBullet playerBullet() {
    	return this.bullet;
    }
    


}
