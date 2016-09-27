package Week2.LabWork1.Task1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Inontran on 26.09.2016.
 */
public class Solution {
    public static int[] array;
    public static BufferedWriter writer;
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();

        BufferedReader fileReader = new BufferedReader(new FileReader("sort.in"));
        int n = Integer.parseInt(fileReader.readLine());
        array = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(fileReader.readLine(), " \t");
        int i = 0;
        while (tokenizer.hasMoreTokens()) array[i++] = Integer.parseInt(tokenizer.nextToken());



        writer = new BufferedWriter(new FileWriter("sort.out"));
        array = mergeSort(array);

        for (i = 0; i < array.length; i++)
        {
            writer.write(String.valueOf(array[i]));
            if (i < array.length-1) writer.write(" ");
        }


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
        searchIndex(aL);
        aR = mergeSort(aR);
        searchIndex(aR);
        return merge(aL, aR);
    }

    private static int[] merge(int[] a, int[] b)
    {
        int i = 0, j = 0, indexAns = 0;
        int[] ans = new int[a.length + b.length];
        while (i < a.length && j < b.length)
        {
            if (j >= b.length || (i < a.length && a[i] < b[j]) )
            {
                ans[indexAns] = a[i];
                i++;
                indexAns++;
            }
            else
            {
                ans[indexAns] = b[j];
                j++;
                indexAns++;
            }

        }
        for ( ; j < b.length; ) ans[indexAns++] = b[j++];
        for ( ; i < a.length; ) ans[indexAns++] = a[i++];
        return ans;
    }

    public static void searchIndex(int[] a)
    {
        for (int i = 0; i <= array.length - a.length; i++)
        {
            int[] partOfArray = Arrays.copyOfRange(array, i, i+a.length);
            if (Arrays.equals(partOfArray, a))
            {
                try {
                    writer.write(String.valueOf(i+1 + " " + (i + a.length) + " " + a[0] + " " + a[a.length - 1]));
                    writer.write(System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
