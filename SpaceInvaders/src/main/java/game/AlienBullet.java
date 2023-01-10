package game;


public class AlienBullet extends Bullet {
	
	private String color = "RED";
	public AlienBullet() {
		super();
	}
	
	//Se actualiza la posicion de la bala
	public void update() {
        super.update(Constants.BULLET_ALIEN_VELOCITY);
    }
	
	//Coloca la bala en la posicion del alien que disparara
	public void shoot(int x, int y) {
		if (super.bulletYPosition() <= 0 || super.bulletYPosition() > Constants.SCREEN_HEIGHT)
    		super.setBulletPosition(x + Constants.ALIEN_WIDTH/2, y + Constants.ALIEN_HEIGHT);
	}
	
	public String color() {
		return this.color;
	}
}
