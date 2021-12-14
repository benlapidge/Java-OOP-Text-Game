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
        String[] inputCommands;
        inputCommands = request.split(" ");
        if (inputCommands[0].equals("lets") && inputCommands[1].equals("talk")) {
            System.out.println("Great! What do you want to talk about? [my name | my location | my purpose]");
            String topic = scan.nextLine();
            switch (topic){
                case "my name":
                    return new ResponseImp(true, "Your name is...'PlayerImp@1030'...or so I am told. What a unique name!");
                case "my location":
                    return new ResponseImp(true, "Your location? I don't think anyone really knows where this place is...");
                case "my purpose":
                    return new ResponseImp(true, "Your purpose is to gather items from the merchants, and ask me questions!");
                default:
                    return new ResponseImp(true, "I don't understand what you are saying...");
            }
        }
        return new ResponseImp(true, "Please, speak with me again if you require further assistance.");
    }
}
