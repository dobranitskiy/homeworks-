package DynamicArray;

import java.util.Arrays;

public class DynamicIntArray implements DynamicArray {
    private int[] data;
    private int size;
    private final CapacityStrategy strategy;

    public DynamicIntArray() {
        this(0, new DoublingStrategy());
    }

    public DynamicIntArray(int initialCapacity) {
        this(initialCapacity, new DoublingStrategy());
    }

    public DynamicIntArray(CapacityStrategy strategy) {
        this(0, strategy);
    }

    public DynamicIntArray(int initialCapacity, CapacityStrategy strategy) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Initial capacity cannot be negative");
        this.data = new int[initialCapacity];
        this.size = 0;
        this.strategy = strategy;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = strategy.nextCapacity(data.length, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    private void checkNotAddIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(int e) {
        ensureCapacity(size + 1);
        data[size++] = e;
        return true;
    }

    @Override
    public boolean containsAll(DynamicArray c) {
        for (int i = 0; i < c.size(); i++) {
            if (!contains(c.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(DynamicArray c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, DynamicArray c) {
        checkAddIndex(index);
        int numNew = c.size();
        if (numNew == 0) {
            return false;
        }
        ensureCapacity(size + numNew);
        System.arraycopy(data, index, data, index + numNew, size - index);
        for (int i = 0; i < numNew; i++) {
            data[index + i] = c.get(i);
        }
        size += numNew;
        return true;
    }

    @Override
    public boolean removeAll(DynamicArray c) {
        boolean modif = false;
        int ind = 0;
        for (int i = 0; i < size; i++) {
            int val = data[i];
            if (!c.contains(val)) {
                data[ind++] = val;
            } else {
                modif = true;
            }
        }
        size = ind;
        return modif;
    }

    @Override
    public boolean retainAll(DynamicArray c) {
        boolean modif = false;
        int ind = 0;
        for (int i = 0; i < size; i++) {
            int val = data[i];
            if (c.contains(val)) {
                data[ind++] = val;
            } else {
                modif = true;
            }
        }
        size = ind;
        return modif;
    }

    @Override
    public void sort() {
        Arrays.sort(data, 0, size);
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int get(int index) {
        checkNotAddIndex(index);
        return data[index];
    }

    @Override
    public int set(int index, int element) {
        checkNotAddIndex(index);
        int old = data[index];
        data[index] = element;
        return old;
    }

    @Override
    public void add(int index, int element) {
        checkAddIndex(index);
        ensureCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    @Override
    public int remove(int index) {
        checkNotAddIndex(index);
        int old = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return old;
    }

    @Override
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int element) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        int[] copy = Arrays.copyOf(data, size);
        return Arrays.toString(copy);
    }
}