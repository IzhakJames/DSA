import Linear.MyArray;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(3);
        myArray.insert(10);
        myArray.insert(20);
        myArray.insert(30);
        myArray.insert(40);
        myArray.removeAt(4);
//        System.out.println(myArray.indexOf(100));
        myArray.print();
    }
}