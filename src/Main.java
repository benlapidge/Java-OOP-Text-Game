import java.util.Scanner;
import java.util.ArrayList;
import gameIF.*;

class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String bar = "====================================================";

    public static void main(String[] args) {
        Player player = new PlayerImp(0);
        setupEntity(player,"player");
        Merchant merchant = new Merchant();
        setupEntity(merchant,"merchant");
        boolean finished = false;
        while (!finished) {
            System.out.println("Merchant code is: " + merchant.getCode());
            System.out.println("Merchant description is: " + merchant.getDescription());
            System.out.print("Items (quantity) owned by player: ");
            printItems(player);
            System.out.print("Items (quantity) owned by merchant: ");
            printItems(merchant);
            System.out.println("Requests understood by merchant:");
            printRequests(merchant);
            System.out.println();
            System.out.print("Enter request to be sent to merchant or 'quit' to exit program: ");
            String request = scanner.nextLine().trim();
            finished = request.equals("quit");
            if (!finished) {
                Response response = merchant.performRequest(request, player);
                if (response == null) {
                    System.out.println("Response was null");
                }
                else {
                    System.out.println("Response status:" +   response.getStatus());
                    System.out.println("Response message:" +      response.getMessage());
                    System.out.println();
                }
            }
        }

    }

    private static void printRequests(NPC npc) {
        ArrayList<String> possRequests = npc.getPossibleRequests();
        if (possRequests == null) {
            System.out.println("null");
        }
        else {
            for (String request:npc.getPossibleRequests()) {
                System.out.println(request);
            }
        }
    }
    private static void printItems(Entity entity) {
        ArrayList<String> itemNames = entity.getItemNames();
        if (itemNames == null) {
            System.out.println("null");
        }
        else {
            for (String name: entity.getItemNames()) {
                System.out.print(name + "(" + entity.getItemQuantity(name) + ") ");
            }
            System.out.println();
        }
    }
    public static void printMap(Game game) {

        char[][] board = new char[game.getHeight()][game.getWidth()];

        int row;
        int col;

        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board[row].length; col++) {
                Entity ent = game.getEntityAt(col,row);
                if (ent == null) {
                    board[row][col]= ('*');
                } else {
                    board[row][col] = (ent.getCode());
                }
                System.out.print(board[row][col]+" ");
            }

            System.out.println();

        }


    }

    private static void setupEntity(Entity entity, String entName) {
        System.out.println("Setting up " + entName);
        boolean finished = false;
        while (!finished) {
            System.out.print("Enter an item name (or type 'quit') to finish setting up " + entName + ": ");
            String itemName = scanner.nextLine().trim();
            finished = itemName.equals("quit");
            if (!finished) {
                System.out.print("Enter the quantity of the item that the " + entName + " owns: ");
                int quantity = -1;
                try {
                    quantity = scanner.nextInt();
                    //Read past end of line
                    scanner.nextLine();
                    entity.setItemQuantity(itemName, quantity);
                }
                catch (Exception ex){
                    System.out.println("That's not a valid number!");
                }
            }
        }
        System.out.println(bar);
    }
}