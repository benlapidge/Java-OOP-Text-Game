import gameIF.Player;
import gameIF.Response;

import java.util.ArrayList;

public class NPC implements gameIF.NPC {
    @Override
    public char getCode() {
        return 0;
    }

    @Override
    public ArrayList<String> getItemNames() {
        return null;
    }

    @Override
    public void setItemQuantity(String name, int quantity) {

    }

    @Override
    public int getItemQuantity(String ItemName) {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public ArrayList<String> getPossibleRequests() {
        return null;
    }

    @Override
    public Response performRequest(String request, Player player) {
        return null;
    }
}
