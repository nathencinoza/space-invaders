package game;

import static org.junit.Assert.*;

import org.junit.Test;


public class AlienArmyTest {
	//Inicializamos la clase AlienArmy
	@Test
	public void AlienArmyInitializeTest() {
		AlienArmy alienArmy = new AlienArmy(); 
		assertEquals(alienArmy.getAliensDirection(), Constants.ALIEN_ARMY_MOVE_RIGHT);
	}

	//Se mueven correctamente los aliens 
	@Test
	public void MoveAliensTest() {
		AlienArmy alienArmy = new AlienArmy();
		Alien random_alien = alienArmy.getAliens().get(10);
		int random_alien_x = random_alien.alienXCoordenate(); 
		alienArmy.moveAliens();
		assertEquals(random_alien.alienXCoordenate(), random_alien_x + Constants.ALIEN_MOVE);
	}
	
	//Verificamos que se eliminan los aliens que se disparan 
	@Test
	public void removeShotAliensTest01() {
		AlienArmy alienArmy = new AlienArmy(); 
		assertTrue(alienArmy.removeShotAliens(Constants.ALIEN_ARMY_START_POSITION_X, Constants.ALIEN_ARMY_START_POSITION_Y));
		assertFalse(alienArmy.removeShotAliens(Constants.ALIEN_ARMY_START_POSITION_X, Constants.ALIEN_ARMY_START_POSITION_Y));
	}
	
	@Test
	public void removeShotAliensTest02() {
		AlienArmy alienArmy = new AlienArmy(); 
		assertTrue(alienArmy.removeShotAliens(Constants.ALIEN_ARMY_START_POSITION_X + Constants.ALIEN_ARMY_SPACE_X, Constants.ALIEN_ARMY_START_POSITION_Y));
	}
	
	@Test
	public void removeShotAliensTest03() {
		AlienArmy alienArmy = new AlienArmy(); 
		assertTrue(alienArmy.removeShotAliens(Constants.ALIEN_ARMY_START_POSITION_X, Constants.ALIEN_ARMY_START_POSITION_Y + Constants.ALIEN_ARMY_SPACE_Y));
	}
	
	@Test
	public void removeShotAliensTest04() {
		AlienArmy alienArmy = new AlienArmy(); 
		assertTrue(alienArmy.removeShotAliens(Constants.ALIEN_ARMY_START_POSITION_X, Constants.ALIEN_ARMY_START_POSITION_Y));
		assertFalse(alienArmy.removeShotAliens(Constants.ALIEN_ARMY_START_POSITION_X, Constants.ALIEN_ARMY_START_POSITION_Y));
	}
	
	@Test
	//Eliminamos una columna entera de aliens 
	public void removeShotAliensTest05() {
		AlienArmy alienArmy = new AlienArmy();
		int position_y = Constants.ALIEN_ARMY_START_POSITION_Y; 
		for (int i = 0; i < Constants.ALIEN_ARMY_ROWS; i ++) {
			assertTrue(alienArmy.removeShotAliens(Constants.ALIEN_ARMY_START_POSITION_X, position_y));
			assertFalse(alienArmy.removeShotAliens(Constants.ALIEN_ARMY_START_POSITION_X, position_y ));
			position_y += (Constants.ALIEN_ARMY_SPACE_Y + Constants.ALIEN_HEIGHT); 
		}	
	}
	
	@Test
	//Eliminamos una fila entera de aliens
		public void removeShotAliensTest06() {
			AlienArmy alienArmy = new AlienArmy();
			int position_x = Constants.ALIEN_ARMY_START_POSITION_X; 
			for (int i = 0; i < Constants.ALIEN_ARMY_COLUMNS; i ++) {
				assertTrue(alienArmy.removeShotAliens(position_x, Constants.ALIEN_ARMY_START_POSITION_Y));
				assertFalse(alienArmy.removeShotAliens(position_x, Constants.ALIEN_ARMY_START_POSITION_Y ));
				position_x += (Constants.ALIEN_ARMY_SPACE_X + Constants.ALIEN_WIDTH); 
			}	
		}
	
	//Verificamos que retorne la posicion de la primera columna correctamente
	@Test
	public void positionFirstRowAliensTest01() {
		AlienArmy alienArmy = new AlienArmy(); 
		assertEquals(Constants.ALIEN_ARMY_START_POSITION_Y, alienArmy.positionFirstRowAliens());
	}
		
	//Verificamos que devuelve correctamente la primera fila con todos sus aliens
	@Test
	public void firstRowAliensTest01() {
		AlienArmy alienArmy = new AlienArmy(); 
		assertEquals(Constants.ALIEN_ARMY_START_POSITION_Y, alienArmy.positionFirstRowAliens());
		assertEquals(Constants.ALIEN_ARMY_COLUMNS, alienArmy.firstRowAliens().size());
	}
	

	//Verificamos que devuelve correctamente la primera fila y un alien menos despues de dispararle 

	@Test
	public void firstRowAliensTest02() {
		AlienArmy alienArmy = new AlienArmy(); 
		assertTrue(alienArmy.removeShotAliens(Constants.ALIEN_ARMY_START_POSITION_X, Constants.ALIEN_ARMY_START_POSITION_Y));
		assertFalse(alienArmy.removeShotAliens(Constants.ALIEN_ARMY_START_POSITION_X, Constants.ALIEN_ARMY_START_POSITION_Y));
		assertEquals(Constants.ALIEN_ARMY_COLUMNS - 1, alienArmy.firstRowAliens().size());
	}
	
	//Verificamos que devuelve la cantidad correcta de aliens en el ejercito
	
	@Test
	public void AlienArmySizeTest02() {
		AlienArmy alienArmy = new AlienArmy(); 
		assertEquals(Constants.ALIEN_ARMY_COLUMNS * Constants.ALIEN_ARMY_ROWS, alienArmy.alienArmyLenght());
	}
	
}