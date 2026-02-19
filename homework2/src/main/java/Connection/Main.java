package Connection;

public class Main {
    private static void runExecutor(PopularCommandExecutor executor) {
        try {
            executor.updatePackages();
        } catch (ConnectionException e) {
            System.out.println("Failed after max attempts. Cause: " + e.getCause());
        }
    }
    public static void main(String[] args) {
        runExecutor(new PopularCommandExecutor(new DefaultConnectionManager(), 3));
        runExecutor(new PopularCommandExecutor(new FaultyConnectionManager(), 3));
    }
}

