import gameIF.*;
import java.util.ArrayList;

public class GameImp implements Game {
    int width;
    int height;
    int playerX;
    int playerY;
    int playerOrientation;
    Entity[][] board;
    PlayerImp player;

    public GameImp(int width, int height, int playerX, int playerY, int playerOrientation) {
        this.width = width;
        this.height = height;
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerOrientation = playerOrientation;
        board = new Entity[height][width];
        player = new PlayerImp(playerOrientation);
        board[playerY][playerX] = player;
    }

    @Override
    public Response requestFacing(String request) {
        // You don't need to implement this yet
        return null;
    }

    @Override
    public Entity getEntityAt(int column, int row) {

        return board[row][column];
    }

    @Override
    public boolean addEntity(Entity entity, int column, int row) {
        if (column > (width-1) || row > (height-1) || column < 0 || row < 0) {

            return false;


        } else if (board[row][column] == null) {
            board[row][column] = entity;
            return true;

        } else {
            return false;
        }

    }

    @Override
    public Response step() {
        if (player.orientation==0){
            board[playerY][playerX] = null;
            board[playerY-1][playerX] = player;
            playerY--;
        } else if (player.orientation==1){
            board[playerY][playerX] = null;
            board[playerY][playerX+1] = player;
            playerX++;

        } else if (player.orientation==2){
            board[playerY][playerX] = null;
            board[playerY+1][playerX] = player;
            playerY++;

        } else if (player.orientation==3){
            board[playerY][playerX] = null;
            board[playerY][playerX-1] = player;
            playerX--;

        }
        return new ResponseImp(true, "test");
    }

    @Override
    public void turn(int orientation) {

        player.setOrientation(orientation);
    }

    @Override
    public int getPlayerX() {
        // Replace with correct code
        return playerX;
    }

    @Override
    public int getPlayerY() {
        // Replace with correct code
        return playerY;
    }

    @Override
    public Player getPlayer() {
        // Replace with correct code

        return player;
    }

    @Override
    public NPC getFacingNPC() {
        // You don't need to implement this yet
        /*
        int faceCol = 1
        int facerow = 1
return (NPC) board[faceCol][faceRow]
         */

        return null;
    }

    @Override
    public int getWidth() {
        // Replace with correct code
        return width;
    }

    @Override
    public int getHeight() {
        // Replace with correct code
        return height;
    }
}