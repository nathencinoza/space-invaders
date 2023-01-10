package game;


public class PlayerBullet extends Bullet {

	private String color = "WHITE"; 
	
	public PlayerBullet() {
		super();
	}
	//Actualiza la posicion Y del jugador
	public void update() {
        super.update(-1 * Constants.BULLET_VELOCITY);
    }
	
	//Inicializa la posicion de la bala del jugador
	public void shoot(int x) {
		if (super.bulletYPosition() <= 0) 
    		super.setBulletPosition(x + Constants.PLAYER_WIDTH, Constants.SCREEN_HEIGHT -  Constants.PLAYER_HEIGHT* 3/2);
	}
	
	public String color() {
		return this.color;
	}
	
}
