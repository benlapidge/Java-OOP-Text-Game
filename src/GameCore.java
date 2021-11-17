import gameIF.Entity;
import gameIF.Game;
import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;

public class GameCore implements Game {
    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public Entity getEntityAt(int column, int row) {
        return null;
    }

    @Override
    public boolean addEntity(Entity entity, int column, int row) {
        return false;
    }

    @Override
    public Response step() {
        return null;
    }

    @Override
    public void turn(int orientation) {

    }

    @Override
    public int getPlayerX() {
        return 0;
    }

    @Override
    public int getPlayerY() {
        return 0;
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public NPC getFacingNPC() {
        return null;
    }

    @Override
    public Response requestFacing(String request) {
        return null;
    }
}
