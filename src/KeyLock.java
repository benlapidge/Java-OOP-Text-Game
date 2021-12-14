import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;

import java.util.ArrayList;

public class KeyLock extends EntityImp implements NPC {

    public KeyLock() {
        super('%');
    }

    @Override
    public String getDescription() {
        return "Find my key to unlock my secrets";
    }

    @Override
    public ArrayList<String> getPossibleRequests() {
        ArrayList<String> requests = new ArrayList<>();
        requests.add("open lock");
        requests.add("provide hint");
        return requests;
    }

    @Override
    public Response performRequest(String request, Player player) {
        if (request.equals("open lock")) {
            if (player.getItemNames().contains("key")) {
                return new ResponseImp(true, "You have unlocked me. I will tell all. You are actually a Java program. This place is not real. That's why your name is so weird (just ask the chatterBox over there!)");
            } else {
                return new ResponseImp(false, "You do not have the key");
            }
        } else if (request.equals("provide hint")) {
            return new ResponseImp(true, "try talking to the merchant");
        }
        return null;
    }
}
