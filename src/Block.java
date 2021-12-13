import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;

import java.util.ArrayList;

public class Block extends EntityImp implements NPC {

    public Block() {
        super('#');
    }

    @Override
    public String getDescription() {

        return "Don't try to get past me. If you do, our world might end!";
    }

    @Override
    public ArrayList<String> getPossibleRequests() {
        return new ArrayList<>(0);
    }


    @Override
    public Response performRequest(String request, Player player) {

        return new ResponseImp(false, "Can't perform this operation");
    }
}
