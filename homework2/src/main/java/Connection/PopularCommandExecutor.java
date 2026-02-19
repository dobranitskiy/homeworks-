package Connection;


public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    PopularCommandExecutor(ConnectionManager manager, int maxAttempts){
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        ConnectionException lastExc = null;
        for (int currAttemp = 0; currAttemp < maxAttempts; ++currAttemp) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (ConnectionException e) {
                lastExc = e;
                System.out.println("Attempt " + currAttemp + " failed: " + e);
            }
        }

        throw new ConnectionException("Haven't done in " + maxAttempts + " attempts", lastExc);
    }

}
