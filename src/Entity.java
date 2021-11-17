import java.util.ArrayList;

public class Entity implements gameIF.Entity {
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
}
