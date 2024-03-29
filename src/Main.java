import java.util.Scanner;

import gameIF.*;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws InterruptedException {

        // intro (comment out to skip)
        String bar = "---------------------------------";
        System.out.println(bar);
        System.out.println("I...I don't feel right.");
        Thread.sleep(1000);
        System.out.println("I..I don't remember...");
        Thread.sleep(2000);
        System.out.println("Where..and who am I?");
        Thread.sleep(3000);
        System.out.println(bar);
        System.out.println("You don't know who you are, or where you are. All you know is that you need to move.");
        System.out.println("Here is how to do so:");
        System.out.println("-_-_-_-_-_PLAYER NAVIGATION_-_-_-_-_-_-");
        System.out.println("turn [up | down | left | right]");
        System.out.println("step [in facing direction]");
        System.out.println("show [map | player | requests | facing]");
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.println("Good luck.");
        System.out.println(bar);
        System.out.println();

        //code
        Scanner scanner = new Scanner(System.in);
        Game game = setupGame();
        boolean finished = false;
        while (!finished) {
            System.out.print("Next request: ");
            String requestStr = scanner.nextLine();
            requestStr = requestStr.trim();
            String[] requestSplit = requestStr.split("\\W+", 2);
            String verb = requestSplit[0];

            if (requestSplit.length > 0) {
                if (verb.equals("show")) {
                    if (requestSplit.length > 1) {
                        if (requestSplit[1].equals("map")) {
                            Map.printMap(game);
                        } else if (requestSplit[1].equals("player")) {
                            printItems(game.getPlayer());
                        } else if (requestSplit[1].equals("facing")) {
                            if (game.getFacingNPC() == null) {
                                System.out.println("There's no one here...");
                            } else {
                                System.out.println(game.getFacingNPC().getDescription());
                                System.out.println(game.getFacingNPC().getPossibleRequests());
                                printItems(game.getFacingNPC());
                            }
                        } else if (requestSplit[1].equals("requests")) {
                            if (game.getFacingNPC() == null) {
                                System.out.println("-_-_-_-_-_PLAYER NAVIGATION_-_-_-_-_-_-");
                                System.out.println("turn [up | down | left | right]");
                                System.out.println("step [in facing direction]");
                                System.out.println("show [map | player | requests | facing]");
                                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                            } else {
                                System.out.println("-_-_-_-_-_PLAYER NAVIGATION_-_-_-_-_-_-");
                                System.out.println("turn [up | down | left | right]");
                                System.out.println("step [in facing direction]");
                                System.out.println("show [map | player | requests | facing]");
                                System.out.println("-_-_-_-_-_NPC INTERACTIONS-_-_-_-_-_-_-");
                                System.out.println(game.getFacingNPC().getPossibleRequests());

                            }
                        }
                    }
                } else if (verb.equals("turn")) {
                    switch (requestSplit[1]) {
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
                } else if (verb.equals("step")) {
                    System.out.println(game.step().getMessage());


                } else if (verb.equals("quit")) {
                    finished = true;
                } else if (game.getFacingNPC() != null && game.getFacingNPC().getPossibleRequests().contains(verb) || game.getFacingNPC().getPossibleRequests().contains(verb + " " + requestSplit[1])) {
                    String request = verb + " " + requestSplit[1];
                    game.requestFacing(request);
                }
            }

        }
    }

    public static Game setupGame() {

        GameCreator game = new GameCreator();
        return game.createGame();

    }

    private static void printItems(Entity entity) {
        ArrayList<String> itemNames = entity.getItemNames();
        if (itemNames == null) {
            System.out.println("null");
        } else {
            for (String name : entity.getItemNames()) {
                System.out.print(name + "(" + entity.getItemQuantity(name) + ") ");
            }
            System.out.println();
        }
    }
}