import gameIF.Game;
import gameIF.Player;

public class GameCreator implements gameIF.GameCreator {
    @Override
    public Game createGame() {
        Game game = new GameImp(10, 7, 3, 4, 0);
        game.addEntity(new Block(), 2, 1);
        game.addEntity(new Block(), 8, 5);
        Merchant merchant = new Merchant();
        merchant.setItemQuantity("coin",10);
        merchant.setItemQuantity("paper", 4);
        game.addEntity(merchant,3,3);
        Player player = game.getPlayer();
        player.setItemQuantity("coin",4);
        player.setItemQuantity("rock", 5);
        return game;
    }
}
