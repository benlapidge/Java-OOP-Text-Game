import gameIF.Player;

public class PlayerImp extends EntityImp implements Player {

    int orientation;
    char code;


    public PlayerImp(int orientation) {
        super('*');
        this.orientation = orientation;
    }

    @Override
    public int getOrientation() {
        return orientation;
    }

    @Override
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    @Override
    public char getCode() {
        switch (orientation) {
            case 0:
                code = '↑';
                break;
            case 1:
                code = '→';
                break;
            case 2:
                code = '↓';
                break;
            case 3:
                code = '←';
                break;
            default:
                System.out.println("Invalid Direction [only select 1-3]");
        }
        return code;
    }
}
