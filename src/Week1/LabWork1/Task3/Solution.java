package Week1.LabWork1.Task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 * Created by Inontran on 25.09.2016.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();

        BufferedReader fileReader = new BufferedReader(new FileReader("smallsort.in"));
        int n = Integer.parseInt(fileReader.readLine());
        int[] array = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(fileReader.readLine(), " \t");
        int i = 0;
        while (tokenizer.hasMoreTokens()) array[i++] = Integer.parseInt(tokenizer.nextToken());

        int tmp;
        for (int j = 1; j < n; j++)
        {
            i = j - 1;
            while (i >= 0 && array[i] > array[i+1])
            {
                tmp = array[i];
                array[i] = array[i+1];
                array[i+1] = tmp;

                i = i - 1;
            }
        }


        BufferedWriter writer = new BufferedWriter(new FileWriter("smallsort.out"));
        for (int j = 0; j < n; j++)
        {
            writer.write(String.valueOf(array[j]));
            if (j < n-1) writer.write(" ");
        }

        if (fileReader!=null) fileReader.close();
        if (writer!=null) writer.close();


        long end = System.currentTimeMillis() - start;
//        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memory = Runtime.getRuntime().totalMemory();
        System.out.println("Time = " + end);
        System.out.println("Memory = " + memory / 1048576);
    }
}
