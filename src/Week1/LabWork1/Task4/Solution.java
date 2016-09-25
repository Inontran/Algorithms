package Week1.LabWork1.Task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Inontran on 25.09.2016.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();

        BufferedReader fileReader = new BufferedReader(new FileReader("sortland.in"));
        int n = Integer.parseInt(fileReader.readLine());
        double[] array = new double[n];
        StringTokenizer tokenizer = new StringTokenizer(fileReader.readLine(), " \t");
        int i = 0;
        while (tokenizer.hasMoreTokens()) array[i++] = Double.parseDouble(tokenizer.nextToken());
        double[] m = Arrays.copyOf(array, n);

        double tmp;
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


        int indexOfThePoorest = 0;
        int indexOfTheRichest = 0;
        int indexOfAverageIncome = 0;
        for (i = 0; i < n; i++)
        {
            if (m[i] == array[0]) indexOfThePoorest = i + 1;
            if (m[i] == array[n/2]) indexOfAverageIncome = i + 1;
            if (m[i] == array[n-1]) indexOfTheRichest = i + 1;
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("sortland.out"));
        writer.write(String.valueOf(indexOfThePoorest));
        writer.write(" ");
        writer.write(String.valueOf(indexOfAverageIncome));
        writer.write(" ");
        writer.write(String.valueOf(indexOfTheRichest));

        if (fileReader!=null) fileReader.close();
        if (writer!=null) writer.close();


        long end = System.currentTimeMillis() - start;
//        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memory = Runtime.getRuntime().totalMemory();
        System.out.println("Time = " + end);
        System.out.println("Memory = " + memory / 1048576);
    }
}
