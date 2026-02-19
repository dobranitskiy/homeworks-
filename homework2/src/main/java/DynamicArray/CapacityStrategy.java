package DynamicArray;

public interface CapacityStrategy {
    int nextCapacity(int currentCapacity, int requiredCapacity);
}