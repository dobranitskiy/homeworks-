package Connection;

public class ConnectionException extends RuntimeException {

    public ConnectionException() {
        super();
    }
    public ConnectionException(String message){
        super(message);
    }
    public ConnectionException(String message, ConnectionException error){
        super(message, error);
    }

}
