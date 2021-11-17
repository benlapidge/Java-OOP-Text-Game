import java.util.ArrayList;
import java.util.HashMap;

public class Entity implements gameIF.Entity {
    HashMap<String, Integer> items = new HashMap<>();
    char code;

    public Entity(char code) {

        this.code = code;
    }

    @Override
    public char getCode() {

        return code;
    }

    @Override
    public ArrayList<String> getItemNames() {

        return new ArrayList<>(items.keySet());
    }

    @Override
    public int getItemQuantity(String name) {

        return items.get(name);
    }

    @Override
    public void setItemQuantity(String name, int quantity) {

        items.put(name, quantity);
    }
}
