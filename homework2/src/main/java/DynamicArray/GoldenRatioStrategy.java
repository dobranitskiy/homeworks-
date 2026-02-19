package DynamicArray;

public class GoldenRatioStrategy implements CapacityStrategy {
    @Override
    public int nextCapacity(int currentCapacity, int requiredCapacity) {
        if (currentCapacity == 0) {
            return Math.max(1, requiredCapacity);
        }
        return Math.max((int)(currentCapacity * 1.618) + 1, requiredCapacity);
    }
}