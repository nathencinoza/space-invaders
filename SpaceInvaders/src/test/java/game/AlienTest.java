package game;

import static org.junit.Assert.*;

import org.junit.Test;


public class AlienTest {
	
	//Inicializa correctamente la clase Alien
	@Test
	public void AlienInitialtest() {
		Alien alien = new Alien(10,20);
		assertTrue(alien.alienIsAlive()); 
		assertEquals(10, alien.alienXCoordenate()); 
		assertEquals(20, alien.alienYCoordenate()); 
	}
	
	//Alien tiene que estar vivo
		@Test
		public void alienIsAliveTest01() {
			Alien alien = new Alien(10,20);
			assertTrue(alien.alienIsAlive()); 
		}
	
		@Test
		public void alienIsAliveTest02() {
			Alien alien = new Alien(50,75);
			alien.alienHasBeenShot(55, 75);
			assertFalse(alien.alienIsAlive()); 
		}
		

		//Alien ha sido disparado  y verificamos que no se puede 
		//disparar dos veces al mismo alien
		@Test
		public void alienHasBeenShotTest01() {
			Alien alien = new Alien(10,20);
			assertTrue(alien.alienHasBeenShot(13, 33)); 
			assertFalse(alien.alienHasBeenShot(13, 33)); 
		}
		
		
		@Test
		public void alienHasBeenShotTest02() {
			Alien alien = new Alien(5,14);
			assertTrue(alien.alienHasBeenShot(5, 15)); 
			assertFalse(alien.alienHasBeenShot(8, 33)); 
		}
		

		//Alien no ha sido disparado
		@Test
		public void alienHasBeenShotTest03() {
			Alien alien = new Alien(10,20);
			assertFalse(alien.alienHasBeenShot(5, 33)); 
		}
		
		@Test
		public void alienHasBeenShotTest04() {
			Alien alien = new Alien(5,14);
			assertFalse(alien.alienHasBeenShot(8, 50)); 
		}
		
		

		//Alien choca con la pared derecha de la pantalla
		@Test
		public void alienHitRightWallTest01() {
			Alien alien = new Alien(Constants.SCREEN_WIDTH - Constants.ALIEN_WIDTH,14);
			//Screen Width - Alien Width = 300 - 10 = 290
			assertTrue(alien.alienHitRightWall()); 
		}
		
		//Alien no choca con la pared derecha de la pantalla
		
		@Test
		public void alienHitRightWallTest02() {
			Alien alien = new Alien(150,14);
			//Screen Width - Alien Width = 300 - 10 = 190
			assertFalse(alien.alienHitRightWall()); 
		}
		
		

		//Alien choca con la pared izquierda de la pantalla

		@Test
		public void alienHitLeftWallTest01() {
			Alien alien = new Alien(0,14);
			//Screen Width - Alien Width = 0 + 10 = 10
			assertTrue(alien.alienHitLeftWall()); 
		}

		//Alien no choca con la pared izquierda de la pantalla

		@Test
		public void alienHitLeftWallTest02() {
			Alien alien = new Alien(35,14);
			//Screen Width - Alien Width = 0 + 10 = 10
			assertFalse(alien.alienHitLeftWall()); 
		}
		
		//Alien se mueve hacia abajo correctamente

		@Test
		public void alienMoveDownTest01() {
			Alien alien = new Alien(35,55);
			alien.alienMoveDown();
			assertEquals(55 + Constants.ALIEN_MOVE_DOWN, alien.alienYCoordenate());  
		}
		

		@Test
		public void alienMoveDownTest02() {
			Alien alien = new Alien(35,100);
			alien.alienMoveDown();
			assertEquals(100 + Constants.ALIEN_MOVE_DOWN, alien.alienYCoordenate());  
		}
		
		
		//Alien se mueve a la derecha correctamente

		@Test
		public void alienMoveRightTest01() {
			Alien alien = new Alien(35,55);
			alien.alienMoveRight();
			assertEquals(35 + Constants.ALIEN_MOVE, alien.alienXCoordenate());  
		}
		

		@Test
		public void alienMoveRightTest02() {
			Alien alien = new Alien(55,100);
			alien.alienMoveRight();
			assertEquals(55 + Constants.ALIEN_MOVE, alien.alienXCoordenate());  
		}
		
		//Alien se mueve a la izquierda correctamente

				@Test
		public void alienMoveLeftTest01() {
			Alien alien = new Alien(35,55);
			alien.alienMoveLeft();
			assertEquals(35 - Constants.ALIEN_MOVE, alien.alienXCoordenate());  
		}
				

		@Test
		public void alienMoveLeftTest02() {
			Alien alien = new Alien(55,100);
			alien.alienMoveLeft();
			assertEquals(55 - Constants.ALIEN_MOVE, alien.alienXCoordenate());  
		}
		
		//Alien devuelve correctamente coordenada Y
		@Test
		public void alienYCoordenateTest01() {
			Alien alien = new Alien(35,14);
			assertEquals(14, alien.alienYCoordenate());  
		}
		
		@Test
		public void alienYCoordenateTest02() {
			Alien alien = new Alien(35,758);
			assertEquals(758, alien.alienYCoordenate());  
		}

		//Alien devuelve correctamente coordenada X

		@Test
		public void alienXCoordenateTest01() {
			Alien alien = new Alien(35,14);
			assertEquals(35, alien.alienXCoordenate());  
		}
		
		@Test
		public void alienXCoordenateTest02() {
			Alien alien = new Alien(147,758);
			assertEquals(147, alien.alienXCoordenate());  
		}
		
		
		
		
		
		
		
		
		
}
