
import java.util.ArrayList;
import gameIF.NPC;
import gameIF.Response;
import gameIF.Player;

class Main {
    public static void main(String[] args) {
        //Below used from EX1
        ResponseImp response = new ResponseImp(true,"Message 1");
        System.out.println("getStatus() returned: " + response.getStatus());
        System.out.println("getMessage() returned: " + response.getMessage());

        //Below used from EX2
        ItemLine line = new ItemLine("coin",2);
        System.out.println("line.getName() returned " + line.getName());
        System.out.println("line.getQuantity() returned " + line.getQuantity());

        //Below used from EX3
        EntityImp entityImp = new EntityImp('*');
        System.out.println("entity.getCode = " + entityImp.getCode());
        entityImp.setItemQuantity("coins", 20);
        entityImp.setItemQuantity("handbags", 1);
        entityImp.setItemQuantity("treacle", 2);
        entityImp.setItemQuantity("stain remover", 1);
        System.out.println(entityImp.getItemNames());

        //Below used from EX4
        System.out.println("Hello world!");
        PlayerImp player = new PlayerImp(0);
        player.setOrientation(0);
        System.out.println(player.getCode());

        //Below used from EX5
        NPC block = new Block();
        char code = block.getCode();
        System.out.println("getCode() returned: " + code);
        String description = block.getDescription();
        System.out.println("getDescription() returned: " + description);
        ArrayList<String> possRequests = block.getPossibleRequests();
        if (possRequests == null) {
            System.out.println("getPossibleRequests() returned: null");
        }
        else {
            System.out.println("getPossibleRequests() returned an ArrayList of size: " + possRequests.size());
        }

        Response response2 = block.performRequest("eat jam",player);
        if (response2 == null) {
            System.out.println("performRequest() returned: null");
        }
        else {
            System.out.println("performRequest() returned a Response with:");
            System.out.println("   status = " + response2.getStatus());
            System.out.println("   message = " + response2.getMessage());
        }

    }
}