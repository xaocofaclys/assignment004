package question2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class GenericType<T> {
    private T[] values;

    public GenericType(T[] values) {
        this.values = values;
    }

    public void display() {
        List<T> xyz = Arrays.asList(values);
        Iterator<T> it = xyz.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}

public class Genericss{
    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        GenericType<Integer> intObject = new GenericType<Integer>(intArray);
        intObject.display();

        Float[] floatArray = { 1.1f, 2.2f, 3.3f, 4.4f, 5.5f };
        GenericType<Float> floatObject = new GenericType<Float>(floatArray);
        floatObject.display();

        String[] stringArray = { "Hello", "World", "Java" };
        GenericType<String> stringObject = new GenericType<String>(stringArray);
        stringObject.display();
        
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        GenericType<Double> doubleObject = new GenericType<Double>(doubleArray);
        doubleObject.display();
    }
}
