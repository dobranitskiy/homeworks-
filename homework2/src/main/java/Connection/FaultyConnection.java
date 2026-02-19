package Connection;

import java.util.Random;

public class FaultyConnection implements Connection {
    private static final Random random = new Random();

    @Override
    public void execute(String command) {
        if (random.nextBoolean()){
            throw new ConnectionException("Connection lost");
        }
    }
    @Override
    public void close() { }
}
