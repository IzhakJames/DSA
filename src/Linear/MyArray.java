package Linear;

/*
 * ArrayList Operations Complexity:
 *
 * get()      -> O(1)
 * set()      -> O(1) replace an element with another
 * add()      -> O(1) amortized, O(n) worst-case (when resizing occurs)
 * insert()   -> O(n) (elements need to be shifted)
 * remove()   -> O(n) (elements need to be shifted)
 * indexOf()  -> O(n) (linear search)
 * iterate()  -> O(n)
 * size()     -> O(1)
 */
public class MyArray {
    private int[] array;
    private int position=0;

    public MyArray(int size) {
        array = new int[size];
    }

    // O(n)
    public void insert(int value){
        if (position == array.length) {
            int[] newArray = new int[position*2];
            // Using system.arraycopy method instead of doing manual copy
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[position++] = value;
    }

    public void print(){
        for (int i = 0; i < position; i++) {
            System.out.println(array[i]);
        }
    }

    // O(n)
    public void removeAt(int index){
        if (index >= position || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            // shift numbers to left
            for (int i = index; i < position; i++) {
                array[i] = array[i+1];
            }
            array[position--] = 0;
        }
    }

    // O(n)
    public int indexOf(int value){
        for (int i = 0; i < position; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // O(1)
    public int get(int index){
        return array[index];
    }

    // O(n)
    public int getMax() {
        int max = array[0];
        for (int i = 1; i < position; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    // O(n)
    public int getMin() {
        int min = array[0];
        for (int i = 1; i < position; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    // O(n)
    public void reverse() {
        int[] newArray = new int[array.length];
        int count = 0;
        for (int i = position-1; i >= 0; i--) {
            newArray[count++] = array[i];
        }
        array = newArray;
    }

    // O(n)
    public void insertAt(int index, int value) {
        if (index > position || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (position == array.length) {
            int[] newArray = new int[position*2];
            // Using system.arraycopy method instead of doing manual copy
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        // shift all values from index to the right
        for (int i = position; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = value;
        position++;

    }


    public void intersect(MyArray other){
        for (int i = 0; i < position; i++) {
            if (other.indexOf(array[i]) >= 0) {
                System.out.println(array[i]);
            }
        }
    }
}
