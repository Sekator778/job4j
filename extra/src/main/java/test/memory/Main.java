package test.memory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * хочу поте рять размер занимаемой памяти объектом
 */
public class Main {
    public static void main(String[] args) throws IOException {
        double[] arrayNoFill = new double[3];

        double[] arrayFill = {0.0, 0.0, 0.0};
        List<double[]> noFillList;
        List<double[]> fillList;

        noFillList = addToList(arrayNoFill);
        fillList = addToList(arrayFill);
        System.out.println("noFill: " + getMemoryLength(noFillList));
        System.out.println("array fill: " + getMemoryLength(fillList));

    }

    private static List<double[]> addToList(double[] arr) {
        List<double[]> result = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            result.add(arr);
        }
        return result;
    }


    public static int getMemoryLength(Object object) throws java.io.IOException {
        ByteArrayOutputStream byteObject = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteObject);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        objectOutputStream.close();
        byteObject.close();

        return byteObject.toByteArray().length;
    }
}
