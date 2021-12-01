import java.util.Scanner;
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
        Scanner scan = new Scanner(System.in);
        String[] inputCommands = new String[2];
        inputCommands = request.split(" ");

        //checks if item is valid, then checks if it is a buy or sell request. Then performs a buy/sell.
//TODO implements coins and values to each item

        if (getItemNames().contains(inputCommands[1])){
            if (inputCommands[0].equals("buy")){

                System.out.println("How many "+inputCommands[1]+" do you want to buy?");
                int quantity = scan.nextInt();
                if(getItemQuantity(inputCommands[1]) >= quantity){
                    player.setItemQuantity(inputCommands[1], player.getItemQuantity(inputCommands[1])+quantity);
                    setItemQuantity(inputCommands[1],getItemQuantity(inputCommands[1])-quantity);
                } else {
                    System.out.println("Invalid Quantity");
                }
            } else if (inputCommands[0].equals("sell")){
                System.out.println("How many "+inputCommands[1]+" do you want to sell?");
                int quantity = scan.nextInt();
                if(player.getItemQuantity(inputCommands[1]) >= quantity){
                    player.setItemQuantity(inputCommands[1],player.getItemQuantity(inputCommands[1])-quantity);
                    setItemQuantity(inputCommands[1],getItemQuantity(inputCommands[1])+quantity);
                } else {
                    System.out.println("Invalid Quantity");
                }
            }

            return new ResponseImp(true, "Done! Have a pleasant day!");
        }

        return new ResponseImp(false, "I don't have that item");
    }
}
