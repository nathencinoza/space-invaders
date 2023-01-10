package game;

import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest {
	//Verificamos inicializacionde Player
	@Test
	public void playerInitializerTest() {
		Player player = new Player(); 
		assertEquals(Constants.PLAYER_LIVES, player.playerLives());
		assertEquals(Constants.PLAYER_START_POSITION, player.playerPosition());
	}
	//Verificamos que devuelve true cuando fue disparado
	@Test
	public void playerHasBeenShotTest01() {
		Player player = new Player(); 
		assertTrue(player.hasBeenShot(Constants.PLAYER_START_POSITION, Constants.SCREEN_HEIGHT + Constants.PLAYER_HEIGHT));
	}
	
	@Test
	public void playerHasBeenShotTest02() {
		Player player = new Player(); 
		assertTrue(player.hasBeenShot(Constants.PLAYER_START_POSITION + Constants.PLAYER_WIDTH/2, Constants.SCREEN_HEIGHT + Constants.PLAYER_HEIGHT));
	}
	

	@Test
	public void playerHasBeenShotTest03() {
		Player player = new Player(); 
		assertTrue(player.hasBeenShot(Constants.PLAYER_START_POSITION + Constants.PLAYER_WIDTH, Constants.SCREEN_HEIGHT + Constants.PLAYER_HEIGHT));
	}
	

	
	//Verificamos que no ha sido disparado cuando la bala no lo toca
	@Test
	public void playerHasBeenShotTest04() {
		Player player = new Player(); 
		assertFalse(player.hasBeenShot(Constants.PLAYER_START_POSITION + Constants.PLAYER_WIDTH+1, Constants.SCREEN_HEIGHT + Constants.PLAYER_HEIGHT));
	}
	
	
	@Test
	public void playerHasBeenShotTest05() {
		Player player = new Player(); 
		assertFalse(player.hasBeenShot(Constants.PLAYER_START_POSITION -1, Constants.SCREEN_HEIGHT + Constants.PLAYER_HEIGHT));
	}
	
	//Verificamos que pierde vidas si fue disparado 
	@Test
	public void playerHasLostLivesTest() {
		Player player = new Player(); 
		assertTrue(player.hasBeenShot(Constants.PLAYER_START_POSITION + Constants.PLAYER_WIDTH, Constants.SCREEN_HEIGHT + Constants.PLAYER_HEIGHT));
		assertEquals(2, player.playerLives());
	}
	



	
}
