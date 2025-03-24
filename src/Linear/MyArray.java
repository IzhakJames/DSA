package Linear;

public class MyArray {
    private int[] array;
    private int position=0;

    public MyArray(int size) {
        array = new int[size];
    }

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

    public int indexOf(int value){
        for (int i = 0; i < position; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
