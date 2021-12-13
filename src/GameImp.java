import gameIF.*;

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
        Response response = getFacingNPC().performRequest(request, getPlayer());
        if (response == null) {
            System.out.println("Response was null");
        } else {
            System.out.println("Response status: " + response.getStatus());
            System.out.println("Response message: " + response.getMessage());
            System.out.println();
        }
        return null;
    }

    @Override
    public Entity getEntityAt(int column, int row) {

        return board[row][column];
    }

    @Override
    public boolean addEntity(Entity entity, int column, int row) {
        if (column > (width - 1) || row > (height - 1) || column < 0 || row < 0) {

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
        if (player.orientation == 0) {
            if (playerY - 1 < 0) {
                return new ResponseImp(false, "Out of Bounds");
            } else if (board[playerY - 1][playerX] == null) {
                board[playerY][playerX] = null;
                board[playerY - 1][playerX] = player;
                playerY--;
            } else {
                return new ResponseImp(false, "Entity on square");
            }
        } else if (player.orientation == 1) {
            if (playerX + 2 > width) {
                return new ResponseImp(false, "Out of Bounds");
            } else if (board[playerY][playerX + 1] == null) {
                board[playerY][playerX] = null;
                board[playerY][playerX + 1] = player;
                playerX++;
            } else {
                return new ResponseImp(false, "Entity on square");
            }

        } else if (player.orientation == 2) {
            if (playerY + 2 > height) {
                return new ResponseImp(false, "Out of Bounds");
            } else if (board[playerY + 1][playerX] == null) {
                board[playerY][playerX] = null;
                board[playerY + 1][playerX] = player;
                playerY++;
            } else {
                return new ResponseImp(false, "Entity on square");
            }

        } else if (player.orientation == 3) {
            if (playerX - 1 < 0) {
                return new ResponseImp(false, "Out of Bounds");
            } else if (board[playerY][playerX - 1] == null) {
                board[playerY][playerX] = null;
                board[playerY][playerX - 1] = player;
                playerX--;
            } else {
                return new ResponseImp(false, "Entity on square");
            }

        }
        return new ResponseImp(true, "Moved to next square");
    }

    @Override
    public void turn(int orientation) {

        player.setOrientation(orientation);

    }

    @Override
    public int getPlayerX() {

        return playerX;
    }

    @Override
    public int getPlayerY() {

        return playerY;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public NPC getFacingNPC() {
        int faceX;
        int faceY;
        if (player.orientation == 0) {
            faceY = playerY - 1;
            faceX = playerX;
            if (board[faceY][faceX] == null) {
                return null;
            } else return (NPC) board[faceY][faceX];
        } else if (player.orientation == 1) {
            faceY = playerY;
            faceX = playerX + 1;
            if (board[faceY][faceX] == null) {
                return null;
            } else return (NPC) board[faceY][faceX];
        } else if (player.orientation == 2) {
            faceY = playerY + 1;
            faceX = playerX;
            if (board[faceY][faceX] == null) {
                return null;
            } else return (NPC) board[faceY][faceX];
        } else if (player.orientation == 3) {
            faceY = playerY;
            faceX = playerX - 1;
            if (board[faceY][faceX] == null) {
                return null;
            } else return (NPC) board[faceY][faceX];
        }

        return null;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
