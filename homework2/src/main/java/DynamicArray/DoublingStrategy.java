package DynamicArray;

public class DoublingStrategy implements CapacityStrategy {
    @Override
    public int nextCapacity(int currentCapacity, int requiredCapacity) {
        if (currentCapacity == 0) {
            return Math.max(1, requiredCapacity);
        }
        return Math.max(currentCapacity * 2, requiredCapacity);
    }
}