import java.util.Arrays;
import java.util.Objects;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className DynamicArray
 * @since 1.0
 */


public class DynamicArray {
    private int size;
    private int capacity;
    private Object[] array;

    /* Parameter construction methods */
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    // No parameter construction method
    public DynamicArray() {
    }

    public void add(Object data) {
        if (size >= capacity){
            grow();
        }

        array[size] = data;
        size++;
    }

    public void insert(int index, Object data) {
        if(size >= capacity) {
            grow();
        }

        for (int i = size; i > index ; i--) {
            array[i] = array[i - 1];
        }
        array[index] = data;
        size++;
    }

    public void delete(Object data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                for (int j = 0; j < (size - i - 1); j++) {
                    array[i + j] = array[i + j +1];
                }
                array[size - 1] = null;
                size--;
                if (size <= (int) (capacity/3)) {
                    shrink();
                }
                break;
            }

        }
    }

    public int search(Object data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {

        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        capacity = newCapacity;
        array = newArray;

    }

    private void shrink() {

        int newCapacity = capacity / 2;
        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        capacity = newCapacity;
        array = newArray;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        String string = "";

        for (int i = 0; i < size; i++) {
            string += array[i] + ", ";
        }

        // remove the last two character
        if(!string.equals("")) {
            string = "[" + string.substring(0, string.length() - 2) + "]";
        } else {
            string = "[]";
        }
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicArray that = (DynamicArray) o;
        return size == that.size && capacity == that.capacity && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }


}
