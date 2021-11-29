import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;

import java.util.ArrayList;

public class Merchant extends EntityImp implements NPC {
    public Merchant() {
        super('£');
    }

    @Override
    public String getDescription() {
        return "I am a Merchant. Buy or Sell?";
    }

    @Override
    public ArrayList<String> getPossibleRequests() {
        ArrayList<String> requests = new ArrayList<>();
        requests.add("buy [rock|paper|scissor]");
        requests.add("sell [rock|paper|scissor]");
        return requests;
    }

    @Override
    public Response performRequest(String request, Player player) {
        return null;
    }
}
