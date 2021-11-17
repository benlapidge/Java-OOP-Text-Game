import gameIF.Response;

public class ResponseImp implements Response {
    boolean status;
    String message;

    public ResponseImp(boolean status, String message) {
        this.message = message;
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public String getMessage()  {
        return message;
    }

}