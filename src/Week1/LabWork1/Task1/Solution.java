package Week1.LabWork1.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 * Created by Inontran on 24.09.2016.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();

        BufferedReader fileReader = new BufferedReader(new FileReader("aplusb.in"));

        int a = 0, b = 0;
        StringTokenizer tokenizer = new StringTokenizer(fileReader.readLine(), " \t");
        if (tokenizer.hasMoreTokens()) a = Integer.parseInt(tokenizer.nextToken());
        if (tokenizer.hasMoreTokens()) b = Integer.parseInt(tokenizer.nextToken());

        BufferedWriter writer = new BufferedWriter(new FileWriter("aplusb.out"));
        writer.write(String.valueOf(a+b));

        if (fileReader!=null) fileReader.close();
        if (writer!=null) writer.close();

        long end = System.currentTimeMillis() - start;
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Time = " + end);
        System.out.println("Memory = " + memory / 1048576);
    }
}
