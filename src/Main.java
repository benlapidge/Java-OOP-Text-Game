import java.util.Scanner;
import gameIF.*;
import java.util.ArrayList;
import java.util.List;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = setupGame();
        boolean finished = false;
        while (!finished) {
            System.out.print("Next request: ");
            String requestStr = scanner.nextLine();
            requestStr = requestStr.trim();
            String [] requestSplit = requestStr.split("\\W+",2);
            String verb = requestSplit[0];

            //TODO: this is the code to get the possible requests. It works, but it wont apply situationally.

          if (requestSplit.length > 0) {
                if (verb.equals("show")) {
                    if (requestSplit.length > 1) {
                        if (requestSplit[1].equals("map")) {
                            Map.printMap(game);
                        } else if (requestSplit[1].equals("player")){
                            printItems(game.getPlayer());
                        } else if (requestSplit[1].equals("facing")){
                            if (game.getFacingNPC() == null){
                                System.out.println("There's no one here...");
                            } else {
                                System.out.println(game.getFacingNPC().getDescription());
                                System.out.println(game.getFacingNPC().getPossibleRequests());
                            }
                        } else if (requestSplit[1].equals("requests")){
                            if (game.getFacingNPC() == null){
                            System.out.println("-_-_-_-_-_PLAYER NAVIGATION_-_-_-_-_-_-");
                            System.out.println("Turn [Up | Down | Left | Right]");
                            System.out.println("Step [In facing direction]");
                            System.out.println("Show [Map | Player | Requests | Facing]");
                            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                        } else {
                                System.out.println("-_-_-_-_-_PLAYER NAVIGATION_-_-_-_-_-_-");
                                System.out.println("Turn [Up | Down | Left | Right]");
                                System.out.println("Step [In facing direction]");
                                System.out.println("Show [Map | Player | Requests | Facing]");
                                System.out.println("-_-_-_-_-_NPC INTERACTIONS-_-_-_-_-_-_-");
                                System.out.println(game.getFacingNPC().getPossibleRequests());

                            }
                        }
                    }
                } else if (verb.equals("turn")){
                    switch(requestSplit[1]){
                        case "up":
                            game.turn(0);
                            break;
                        case "down":
                            game.turn(2);
                            break;
                        case "left":
                            game.turn(3);
                            break;
                        case "right":
                            game.turn(1);
                            break;
                        default:
                            break;
                    }
                } else if (verb.equals("step")){
                    System.out.println(game.step().getMessage());
                    Map.printMap(game);


                } else if (game.getFacingNPC() != null && game.getFacingNPC().getPossibleRequests().contains(verb)){
                      Response response = game.getFacingNPC().performRequest(verb+" "+requestSplit[1], game.getPlayer());
                      if (response == null) {
                          System.out.println("Response was null");
                      }
                      else {
                          System.out.println("Response status: " +   response.getStatus());
                          System.out.println("Response message: " +      response.getMessage());
                          System.out.println();
                      }
                  }
              }
                finished = verb.equals("quit");
            }
        }

    public static Game setupGame() {
        //MODIFY THIS METHOD IF YOU WANT TO CHANGE THE INITIAL GAME STATE
        Game game = new GameImp(10, 7, 3, 4, 0);
        game.addEntity(new Block(), 2, 1);
        game.addEntity(new Block(), 8, 5);
        Merchant merchant = new Merchant();
        merchant.setItemQuantity("coin",3);
        merchant.setItemQuantity("paper", 2);
        game.addEntity(merchant,3,3);
        Player player = game.getPlayer();
        player.setItemQuantity("coin",4);
        player.setItemQuantity("rock", 5);
        return game;
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
}