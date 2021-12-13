import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;

import java.util.ArrayList;
import java.util.Scanner;

public class Chatter extends EntityImp implements NPC {
    public Chatter() {

        super('@');
    }

    @Override
    public String getDescription() {

        return "I've been watching you, struggling to turn and step your way over here. Are you lost?";
    }

    @Override
    public ArrayList<String> getPossibleRequests() {
        ArrayList<String> requests = new ArrayList<>();
        requests.add("lets talk");
        requests.add("go away");
        return requests;
    }

    @Override
    public Response performRequest(String request, Player player) {
        Scanner scan = new Scanner(System.in);
        String[] inputCommands = new String[2];
        inputCommands = request.split(" ");
        if (inputCommands[0].equals("lets") && inputCommands[1].equals("talk")) {
            System.out.println("Great! What do you want to talk about? [my name | my location | your purpose]");
            //return new ResponseImp(true, "Great! What do you want to talk about? [my name | my location | your purpose]");
            if (inputCommands[0].equals("my") && inputCommands[1].equals("name")) {
                return new ResponseImp(true, "Your name is NULL POINTER, or at least that's what the word around the 'block' is!");
            }
        } else if (inputCommands[0].equals("my") && inputCommands[1].equals("location")){
            return new ResponseImp(true, "You are located in the grid");

        } //else if ()
        return new ResponseImp(false, "Oh, sorry...");
    }
}
