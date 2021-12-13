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
        return "Wow, have you been robbed? Where is your equipment?";
    }

    @Override
    public ArrayList<String> getPossibleRequests() {
        ArrayList<String> requests = new ArrayList<>();
        requests.add("buy");
        requests.add("sell");
        return requests;
    }

    @Override
    public Response performRequest(String request, Player player) {
        Scanner scan = new Scanner(System.in);
        String[] inputCommands;
        inputCommands = request.split(" ");

        if (inputCommands[0].equals("buy")) {
            if (player.getItemNames().contains(inputCommands[1])) {
                System.out.println("How many " + inputCommands[1] + " do you want to buy?");
                int quantity = scan.nextInt();
                if (getItemQuantity(inputCommands[1]) >= quantity) {
                    player.setItemQuantity(inputCommands[1], player.getItemQuantity(inputCommands[1]) + quantity);
                    player.setItemQuantity("coin", player.getItemQuantity("coin") - 2);
                    setItemQuantity(inputCommands[1], getItemQuantity(inputCommands[1]) - quantity);
                    setItemQuantity("coin", getItemQuantity("coin") + 2);
                } else {
                    return new ResponseImp(false, "Invalid Quantity");
                }

            } else if (!getItemNames().contains(inputCommands[1])) {
                return new ResponseImp(false, "I don't have that item!");
            } else {
                System.out.println("How many " + inputCommands[1] + " do you want to buy?");
                int quantity = scan.nextInt();
                if (getItemQuantity(inputCommands[1]) >= quantity) {
                    player.setItemQuantity(inputCommands[1], quantity);
                    player.setItemQuantity("coin", player.getItemQuantity("coin") - 2);
                    setItemQuantity(inputCommands[1], getItemQuantity(inputCommands[1]) - quantity);
                    setItemQuantity("coin", getItemQuantity("coin") + 2);
                } else {
                    return new ResponseImp(false, "Invalid Quantity");
                }
            }
            return new ResponseImp(true, "Don't take it all at once!");

        } else if (inputCommands[0].equals("sell")) {
            System.out.println("How many " + inputCommands[1] + " do you want to sell?");
            int quantity = scan.nextInt();
            if (player.getItemQuantity(inputCommands[1]) >= quantity) {
                setItemQuantity(inputCommands[1], quantity);
                setItemQuantity("coin", getItemQuantity(inputCommands[1]) - 1);
                player.setItemQuantity(inputCommands[1], player.getItemQuantity(inputCommands[1]) - quantity);
                player.setItemQuantity("coin", player.getItemQuantity("coin") + quantity);

            } else {
                return new ResponseImp(false, "Invalid Quantity");
            }
        }

        return new ResponseImp(true, "Good luck, and watch out for those blocks. Weird ones they are...");
    }

}
