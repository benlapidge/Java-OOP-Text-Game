import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;

import java.util.ArrayList;

public class Block extends EntityImp implements NPC {

    public Block() {
        //Replace with correct code
        super('#');
    }

    @Override
    public String getDescription() {
        //Replace with correct code
        return "This is a Block";
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
