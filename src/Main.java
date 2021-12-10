import java.util.Scanner;
import gameIF.*;

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
            String noun = requestSplit[1];
            if (requestSplit.length > 0) {
                if (verb.equals("show")) {
                    if (requestSplit.length > 1) {
                        if (noun.equals("map")) {
                            Map.printMap(game);
                        }
                    }
                } else if (verb.equals("turn")){
                    switch(noun){
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
                    game.step();
                    Map.printMap(game);

                } else if (verb.equals("get")){
                    if (noun.equals("facing")){
                        System.out.println(game.getFacingNPC().getDescription());
                        System.out.println(game.getFacingNPC().getPossibleRequests());
                    }
                }
                finished = verb.equals("quit");
            }
        }
    }

    public static Game setupGame() {
        //MODIFY THIS METHOD IF YOU WANT TO CHANGE THE INITIAL GAME STATE
        Game game = new GameImp(10, 7, 3, 4, 0);
        game.addEntity(new Block(), 2, 1);
        game.addEntity(new Block(), 8, 5);
        game.addEntity(new Merchant(), 2, 4);
        return game;
    }
}