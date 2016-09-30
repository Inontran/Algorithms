package testers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Inontran on 30.09.2016.
 */
public class NumbersRandomizer {
    public static void main(String[] args) throws Exception{
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter file name:");
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(consoleReader.readLine()));
        System.out.println("Enter size of array:");
        int n = Integer.parseInt(consoleReader.readLine());

        Random randomizer = new Random();
        fileWriter.write(String.valueOf(n));
        fileWriter.write(System.lineSeparator());
        for (int i = 0; i < n; i++)
        {
            fileWriter.write(String.valueOf(randomizer.nextInt(n)));
            if (i < n -1) fileWriter.write(" ");
        }

        if (consoleReader!=null) consoleReader.close();
        if (fileWriter!=null) fileWriter.close();
    }
}
