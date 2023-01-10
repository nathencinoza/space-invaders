package game;

public class MoveRight implements  Action {
	
	@Override
    public void apply(Player player) {
			if (player.playerPosition() + Constants.PLAYER_WIDTH + 2*Constants.PLAYER_MOVE  <= Constants.SCREEN_WIDTH ) {
				player.playerSetPosition(player.playerPosition() + Constants.PLAYER_MOVE);
            }
	}
}
