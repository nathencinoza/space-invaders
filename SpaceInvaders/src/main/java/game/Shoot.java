package game;


public class Shoot implements Action {
	@Override
    public void apply(Player player) {
			player.shoot();
	}
}
