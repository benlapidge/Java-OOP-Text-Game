import gameIF.Game;
import gameIF.Player;

public class GameCreator implements gameIF.GameCreator {
    @Override
    public Game createGame() {
        Game game = new GameImp(10, 7, 3, 4, 0);
        game.addEntity(new Block(), 2, 1);
        game.addEntity(new Block(), 8, 5);
        Chatter chatter = new Chatter();
        game.addEntity(chatter, 1, 1);
        KeyLock keyLock = new KeyLock();
        game.addEntity(keyLock,8,1);
        Merchant merchant = new Merchant();
        merchant.setItemQuantity("coin", 40);
        merchant.setItemQuantity("soma", 10);
        merchant.setItemQuantity("soylent", 20);
        merchant.setItemQuantity("key", 1);
        game.addEntity(merchant, 3, 3);
        Player player = game.getPlayer();
        player.setItemQuantity("coin", 20);
        player.setItemQuantity("minerals", 5);
        return game;

    }
}
