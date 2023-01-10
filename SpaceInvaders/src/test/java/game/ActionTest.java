package game;

import static org.junit.Assert.*;

import org.junit.Test;



public class ActionTest {

	@Test
	public void ShootTest() {
		Player  player = new Player(); 
		Shoot shoot = new Shoot();
		shoot.apply(player);
		assertEquals(player.playerBullet().bulletXPosition(), player.playerPosition() + Constants.PLAYER_WIDTH);
		assertEquals(player.playerBullet().bulletYPosition(), Constants.SCREEN_HEIGHT -  Constants.PLAYER_HEIGHT* 3/2);
	}
	@Test
	public void MoveRightTest() {
		Player player = new Player(); 
		MoveRight move = new MoveRight();
		move.apply(player); 
		assertEquals(player.playerPosition(), Constants.PLAYER_START_POSITION + Constants.PLAYER_MOVE); 
	}
	@Test
	public void MoveLeftTest() {
		Player player = new Player(); 
		MoveLeft move = new MoveLeft();
		move.apply(player); 
		assertEquals(player.playerPosition(), Constants.PLAYER_START_POSITION - Constants.PLAYER_MOVE); 
	}

}
