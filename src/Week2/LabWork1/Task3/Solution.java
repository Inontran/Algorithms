package Week2.LabWork1.Task3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Inontran on 30.09.2016.
 */
public class Solution {
    public static int countInversions = 0;
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        BufferedReader fileReader = new BufferedReader(new FileReader("inversions.in"));

        int n = 0;
        if (fileReader.ready()) n = Integer.parseInt(fileReader.readLine());
        int[] array = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(fileReader.readLine(), " \t");
        int i = 0;
        while (tokenizer.hasMoreTokens()) array[i++] = Integer.parseInt(tokenizer.nextToken());

        mergeSort(array);
//        for (i = 0; i < n; i++)
//        {
//            for (int j = i + 1; j < n; j++)
//            {
//                if (array[i] > array[j]) countInversions++;
//            }
//        }


        BufferedWriter writer = new BufferedWriter(new FileWriter("inversions.out"));
        writer.write(String.valueOf(countInversions));

        if (fileReader!=null) fileReader.close();
        if (writer!=null) writer.close();


        long end = System.currentTimeMillis() - start;
//        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memory = Runtime.getRuntime().totalMemory();
        System.out.println("Time = " + end);
        System.out.println("Memory = " + memory / 1048576);
    }

    public static int[] mergeSort(int[] a)
    {
        if (a.length <=1) return a;
        int m = a.length/2;
        int[] aL = Arrays.copyOfRange(a, 0, m);
        int[] aR = Arrays.copyOfRange(a, m, a.length);
        aL = mergeSort(aL);
        aR = mergeSort(aR);
        return merge(aL, aR);
    }

    private static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, indexAns = 0;
        int[] ans = new int[a.length + b.length];
        while (i < a.length)
        {
            while (j < b.length)
            {
                if (a[i] > b[j]) countInversions++;
                j++;
            }
            i++;
            j = 0;
        }
        for (i = 0; i < a.length; i++) ans[indexAns++] = a[i];
        for (j = 0; j < b.length; j++) ans[indexAns++] = b[j];
        return ans;
    }
}
