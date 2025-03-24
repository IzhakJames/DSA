import Linear.MyArray;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(3);
        myArray.insert(10);
        myArray.insert(20);
        myArray.insert(30);
        myArray.insert(40);
        myArray.insert(50);
//        myArray.removeAt(1);
//        System.out.println(myArray.indexOf(100));
//        System.out.println(myArray.get(2));
//        myArray.reverse();
//        System.out.println(myArray.getMax());
//        System.out.println(myArray.getMin());
//        myArray.insertAt(3, 60);
//        myArray.print();

        MyArray myArray2 = new MyArray(3);
        myArray2.insert(10);
        myArray2.insert(80);
        myArray2.insert(40);

        myArray.intersect(myArray2);
    }
}