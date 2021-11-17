import gameIF.Player;

public class PlayerImp extends Entity implements Player {
    int orientation;
    char code;

    public PlayerImp(int orientation) {
        super('*');
        this.orientation = orientation;
    }

    @Override
    public int getOrientation() {
        //Put a correct implementation here
        return orientation;
    }

    @Override
    public void setOrientation(int orientation) {
        this.orientation = orientation;
        if (orientation == 0){
            code = 0x2191;
        } else if (orientation == 1){
            code = 0x2192;
        } else if (orientation == 2){
            code = 0x2193;
        } else if (orientation == 3){
            code = 0x2190;
        } else {
            System.out.println("Invalid Direction [only select 1-3]");
        }
    }

    @Override
    public char getCode() {
        //Put a correct implementation here
        return code;
    }
}
