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
        ArrayList<String> possibleRequests = new ArrayList<>(0);
        return possibleRequests;
    }


    @Override
    public Response performRequest(String request, Player player) {

        ResponseImp response = new ResponseImp(false, "Can't perform this operation");
        return response;
    }
}