package Connection;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final Random random = new Random();

    @Override
    public Connection getConnection() {
        if (random.nextInt(10) < 4) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
