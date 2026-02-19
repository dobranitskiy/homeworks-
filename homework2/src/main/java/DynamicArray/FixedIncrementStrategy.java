package DynamicArray;

public class FixedIncrementStrategy implements CapacityStrategy {
    private final int increment;

    public FixedIncrementStrategy(int increment) {
        if (increment <= 0) {
            throw new IllegalArgumentException("Type positive integer");
        }
        this.increment = increment;
    }

    @Override
    public int nextCapacity(int currentCapacity, int requiredCapacity) {
        return Math.max(currentCapacity + increment, requiredCapacity);
    }
}