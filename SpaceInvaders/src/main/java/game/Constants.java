package game;


public class Constants {
	//Screen 
		public static final int SCREEN_WIDTH = 680; 
		public static final int SCREEN_HEIGHT = 480;
		
		//Alien
		public static final int ALIEN_WIDTH = 30;
		public static final int ALIEN_HEIGHT = 25;
		public static final int ALIEN_MOVE_DOWN = 15; 
		public static final int ALIEN_MOVE = 10; 
		
		//Alien Army 
		public static final int ALIEN_ARMY_ROWS = 4;
		public static final int ALIEN_ARMY_COLUMNS = 11;
		public static final int ALIEN_ARMY_SPACE_X= 10; 
		public static final int ALIEN_ARMY_SPACE_Y= 10;
		public static final int ALIEN_ARMY_START_POSITION_X = 50; 
		public static final int ALIEN_ARMY_START_POSITION_Y = 50; 
		public static final int ALIEN_ARMY_MOVE_RIGHT = 1; 
		public static final int ALIEN_ARMY_MOVE_LEFT = 0; 
		
		//Player 
		public static final int PLAYER_HEIGHT = 40;
		public static final int PLAYER_WIDTH = 60;
		public static final int PLAYER_LIVES = 3;
		public static final int PLAYER_MOVE = Constants.PLAYER_WIDTH/2; 
		public static final int PLAYER_START_POSITION = Constants.SCREEN_WIDTH/2;
		public static final int PLAYER_MOVE_RIGHT = 1; 
		public static final int PLAYER_MOVE_LEFT = 0;
		public static final int PLAYER_POINTS = 10;
		
		//Bullet
		public static final int BULLET_VELOCITY = 5; 
		public static final int BULLET_ALIEN_VELOCITY = 30; 
		public static final int BULLET_WIDTH = 5;
		public static final int BULLET_HEIGHT = 15; 

}
