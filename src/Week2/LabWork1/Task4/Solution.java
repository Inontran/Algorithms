package Week2.LabWork1.Task4;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Inontran on 01.10.2016.
 */
public class Solution {
    static int[] array;
    public static void main(String[] args) throws IOException {


        BufferedReader fileReader = new BufferedReader(new FileReader("antiqs.in"));
        int n = Integer.parseInt(fileReader.readLine());
        array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) array[i] = i+1;
        array = transposition(0, n-1, array);
        System.out.println();
//        for (int i = 0; i < n; i++) System.out.print(array[i] + " ");
//        System.out.println();




        BufferedWriter writer = new BufferedWriter(new FileWriter("antiqs.out"));
        for (int i = 0; i < array.length; i++)
        {
            writer.write(String.valueOf(array[i]));
            if (i < array.length - 1) writer.write(" ");
        }


        if (fileReader!=null) fileReader.close();
        if (writer!=null) writer.close();

        long start = System.currentTimeMillis();
        qsort(0, n-1);
//        sort(array);
        long end = System.currentTimeMillis() - start;
//        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memory = Runtime.getRuntime().totalMemory();
        System.out.println("Time = " + end);
        System.out.println("Memory = " + memory / 1048576);
    }

    public static int[] transposition(int left, int right, int[] a)
    {
        if (a.length <=1 ) return a;
        int key = a.length / 2;
        System.out.print(key + " ");
        if (a[key] < a[a.length-1]) {
            int temp = a[key];
            a[key] = a[a.length - 1];
            a[a.length - 1] = temp;
        }
        int[] aL = Arrays.copyOfRange(a, 0, key);
        int[] aR = Arrays.copyOfRange(a, key+1, a.length);
        aL = transposition(left, key-1, aL);
        aR = transposition(key+1, right, aR);
        int[] result = new int[a.length];
        int indexResult = 0;
        for (int i = 0; i < aL.length; i++) result[indexResult++] = aL[i];
        result[indexResult++] = a[key];
        for (int i = 0; i < aR.length; i++) result[indexResult++] = aR[i];
        return result;
    }

    public static void qsort(int left, int right)
    {
        int i, j, key, temp;
        System.out.print( (left+right)/2 + " ");
        key = array[(left+right)/2];
        i = left;
        j = right;
        do {
            while (array[i] < key) i++;
            while (key < array[j]) j--;
            if (i <= j)
            {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++; j--;
            }
        } while (i < j);
        if (left < j) qsort(left, j);
        if (i < right) qsort(i, right);
    }

    public static void sort (int[] arr) {
        for (int min = 0; min < arr.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < arr.length; j++) {
                if(arr[j] < arr[least]) {
                    least = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[least];
            arr[least] = tmp;
        }
    }
}
