package game;


public class Alien { 
	
	private int x_coordinate; 
	private int y_coordinate; 
	private boolean alive;
	
	//Constructor 
	public Alien(int x_coordinate, int y_coordinate) {
		this.x_coordinate = x_coordinate; 
		this.y_coordinate = y_coordinate; 
		this.alive = true; 
	}
	
	
	//Devuelve si el alien está vivo
	public boolean alienIsAlive() {
		return this.alive; 
	}
	
 
	
	//Verifica si el alien ha sido disparado, si ha sido disparado su estado de alive pasa a ser "false" y devuelve "true".
	public boolean alienHasBeenShot(int bullet_x_coordinate, int bullet_y_coordinate) {
		if (!alienIsAlive()) 
			return false;
		
		if ((bullet_x_coordinate >= this.x_coordinate) && (bullet_x_coordinate <= this.x_coordinate + Constants.ALIEN_WIDTH)) 
			if ((bullet_y_coordinate >= this.y_coordinate) && (bullet_y_coordinate <= this.y_coordinate+ Constants.ALIEN_HEIGHT)) {
				this.alive = false;
				return true;
			}
		return false; 
	}
	
	//Verifica si el alien choco con la pared derecha 
	public boolean alienHitRightWall() {
		return (this.x_coordinate + Constants.ALIEN_MOVE >= Constants.SCREEN_WIDTH - Constants.ALIEN_WIDTH); 
	}
	
	
	//Verifica si el alien choco con la pared izquierda
	public boolean alienHitLeftWall() {
		return (this.x_coordinate - Constants.ALIEN_MOVE <= 0); 
	}
	
	//Mueve al alien para abajo 
	public void alienMoveDown() {
		this.y_coordinate += Constants.ALIEN_MOVE_DOWN;
	}
	
	//Mueve al alien para la derecha
	public void alienMoveRight() {
		this.x_coordinate += Constants.ALIEN_MOVE; 
	}
	//Mueve al alien para la izquierda
	public void alienMoveLeft() {
		this.x_coordinate -= Constants.ALIEN_MOVE; 
	}
	//Devuelve la coordenada Y del alien
	public int alienYCoordenate() {
		return this.y_coordinate;
	}
	
	//Devuelve la coordenada X del alienigena 
	public int alienXCoordenate() {
		return this.x_coordinate;
	}
}
