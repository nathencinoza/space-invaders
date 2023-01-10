package game;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class AlienArmy {      
	

    private ArrayList<Alien> aliens; 
	private AlienBullet bullet;
    private int direction; // 0 si se mueve a la izquierda, 1 si se mueve a la derecha. 
    
    //Constructor
    public AlienArmy() {
    	this.direction = 1; 
    	this.aliens = new ArrayList<Alien>();
    	this.bullet = new AlienBullet();
    	createAliens();
    }
     
    //Crea el ejercito de alienigenas
    private void createAliens() {
    	int alien_x_position = Constants.ALIEN_ARMY_START_POSITION_X;
    	for (int i = 0; i < Constants.ALIEN_ARMY_COLUMNS; i++) {
	    	int alien_y_position = Constants.ALIEN_ARMY_START_POSITION_Y;
    	    for (int j = 0; j < Constants.ALIEN_ARMY_ROWS; j++) {
    	    	this.aliens.add(new Alien(alien_x_position, alien_y_position));
    	    	alien_y_position += (Constants.ALIEN_ARMY_SPACE_Y + Constants.ALIEN_HEIGHT);
    	    }
    		alien_x_position += (Constants.ALIEN_ARMY_SPACE_X + Constants.ALIEN_WIDTH);
    	}
    }
    //Devuelve la direccion de los alienigenas
    public int getAliensDirection() {
    	return (this.direction);
    }
    
    //Cambia la direccion de los aliens cuando tocan alguna pared y los mueve para abajo
    public boolean changeAliensDirection() {
    	for (int i = 0; i < this.aliens.size(); i++) {
    		if (this.aliens.get(i).alienHitRightWall()) { 
    			this.direction = 0;
    			return true;
    		}
    		else if (this.aliens.get(i).alienHitLeftWall()) {
    			this.direction = 1;
    			return true;
    		}
    	}
		return false; 
    }
    
    
    //Mueve los alienigenas para abajo 
    private void moveAliensDown() {
    	for (int i = 0; i < this.aliens.size(); i++) 
    		this.aliens.get(i).alienMoveDown();
    }
    
    //Mueve los alien para la izquierda
    private void moveAliensLeft() {
    	for (int i = 0; i < this.aliens.size(); i++) 
    		this.aliens.get(i).alienMoveLeft();
    }
    
    //Mueve los alien para la derecha
    private void moveAliensRight() {
    	for (int i = 0; i < this.aliens.size(); i++) 
    		this.aliens.get(i).alienMoveRight();
    }
   
    
    /*Mueve a los aliens dependiendo de la direccion y si ha chocado con la pared, ej: si va a la izquierda y no choco
    con la pared, se mueve a la izquierda, en caso de que haya chocado con la pared se mueve a la derecha*/
    public void moveAliens() {
    	if (this.getAliensDirection() == Constants.ALIEN_ARMY_MOVE_LEFT) {
    		if (!this.changeAliensDirection()) 
    			this.moveAliensLeft();
   			else {
   				this.moveAliensDown();
   				this.moveAliensRight();
   			}
   		}
   		else if (this.getAliensDirection() == Constants.ALIEN_ARMY_MOVE_RIGHT) {
   			if (!this.changeAliensDirection())   				
   				this.moveAliensRight();
   			else  {
    			this.moveAliensDown(); //si se chequea uno, y no esta en la pared se sigue moviendo sin consultar si ninguno esta en la pared
    			this.moveAliensLeft();
    		}
    		
    	}
    }
    
   
    //Verifica si hay aliens que han sido disparados, en caso de que hayan los elimina 
    public boolean removeShotAliens(int x_bullet_coordinate, int y_bullet_coordinate) {
    	for (int i = 0; i < this.aliens.size(); i++) {
    		if(this.aliens.get(i).alienHasBeenShot(x_bullet_coordinate, y_bullet_coordinate)) {
        		aliens.remove(i);
        		return true;
    		}
    	}
    	return false;
    }
    
    //Devuelve la posicion en el eje Y de la posicion de la primera fila de los aliens 
    public int positionFirstRowAliens() {
    	ArrayList<Integer> positions = new ArrayList<Integer>(); 
    	
    	for (int i = 0; i < this.aliens.size(); i++) 
    		positions.add(aliens.get(i).alienYCoordenate()); 

    	Collections.sort(positions);
    	return (positions.get(0)); 
    }
    
    //Devuelve la posicion en el eje Y de la posicion de la ultima fila de los aliens 
    public int positionLastRowAliens() {
    	ArrayList<Integer> positions = new ArrayList<Integer>(); 
    	
    	for (int i = 0; i < this.aliens.size(); i++) 
    		positions.add(aliens.get(i).alienYCoordenate()); 
    	
    	Collections.sort(positions);
    	Collections.reverse(positions);
    	return (positions.get(0)); 
    }
    
    //Devuelve el arrayList de los aliens que pertenecen al ejercito
    public ArrayList<Alien> getAliens() {
    	return this.aliens;
    }
    
    //Devuelve un ArrayList de los alienigenas de la primera fila
    public ArrayList<Alien> firstRowAliens() {
    	ArrayList<Alien> topAliens = new ArrayList<Alien>(); 
    	
    	for (int i = 0; i < this.aliens.size(); i++) 
    		if (aliens.get(i).alienYCoordenate() == positionFirstRowAliens()) 
        		topAliens.add(aliens.get(i)); 
    	
        return topAliens;
    }
    
    //Elige un alienigena al azar de la primera fila y hace que dispare 
    public void makeRandomAlienShoot() {
    	int random_int  = (int)Math.floor(Math.random()*(this.firstRowAliens().size()));
    	Alien random_alien = this.firstRowAliens().get(random_int);
    	this.bullet.shoot(random_alien.alienXCoordenate(), random_alien.alienYCoordenate());
    }
    
    //Retorna la bala del ejercito
   	public AlienBullet alienBullet() {
       	return this.bullet;
       }
   	
   	//Devuelve la cantidad de aliens que hay en el ejercito
       public int alienArmyLenght() {
       	return this.aliens.size(); 
       }
}