import gameIF.Player;

import java.util.ArrayList;

public class Character implements Player {
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

    @Override
    public int getOrientation() {
        return 0;
    }

    @Override
    public void setOrientation(int orientation) {

    }
}
