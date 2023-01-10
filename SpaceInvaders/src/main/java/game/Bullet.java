package game;


public class Bullet {
	private int x_coordinate; 
	private int y_coordinate;
	
	//Hace que la bala sea "invisible"
	public Bullet() {
		setBulletInvisible();
	}
	
	//Coloca a la bala en una posición no visible
	public void setBulletInvisible() {
		this.x_coordinate = -1; 
		this.y_coordinate = - Constants.BULLET_WIDTH -5;
	}
	
	//Verifica que la bala este dentro del rango de altura de la pantalla, en caso contrario la vuelve invisible 
	public boolean offScreen() {
		if (this.y_coordinate <= 0) {
			this.setBulletInvisible();
			return true;
		}
		return false;
	}
	
	//Actualiza la posicion de la bala
	public void update(int constant) {
		if(!this.offScreen()) {
			this.y_coordinate += constant;
		}
	}
	
	//Inicializa los valores de las coordenadas de la bala
	public void setBulletPosition(int x, int y) {
		this.x_coordinate = x; 
		this.y_coordinate = y; 
	}
	
	//Devuelve la posicion de la coordenada X de la bala
	public int bulletXPosition() {
		return this.x_coordinate;
	}
	
	//Devuelve la posicion de la coordenada Y de la bala 
	public int bulletYPosition() {
		return this.y_coordinate;
	}

	public String color() {
		return "";
	}
}
