package game;

public class MoveLeft implements Action{
	
	@Override
    public void apply(Player player) {
		if ((player.playerPosition() - Constants.PLAYER_MOVE >= 0) || (player.playerPosition() - Constants.PLAYER_MOVE <= 0 && player.playerPosition() > 0)) {
			player.playerSetPosition(player.playerPosition() - Constants.PLAYER_MOVE);
        }
	
	} 
}
