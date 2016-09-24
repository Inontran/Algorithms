package Week1.LabWork1.Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 * Created by Inontran on 24.09.2016.
 */

//первый аргумент программы - путь входного файла, второй аргумент - путь выходного файла.
public class Solution {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();//начинаем отчет времени начала работы алгоритма

        //открываем поток на чтение файла
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        //получаем значение a и b
        int a = 0, b = 0;
        StringTokenizer tokenizer = new StringTokenizer(fileReader.readLine(), " \t");
        if (tokenizer.hasMoreTokens()) a = Integer.parseInt(tokenizer.nextToken());
        if (tokenizer.hasMoreTokens()) b = Integer.parseInt(tokenizer.nextToken());

        //записываем сумму в файл
        FileWriter writer = new FileWriter(args[1]);
        writer.write(a+b);

        //закрываем потоки
        if (fileReader!=null) fileReader.close();
        if (writer!=null) writer.close();


        long end = System.currentTimeMillis() - start; // считаю сколько секунд длилась "программа"
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // считаю сколько памяти было занято.
        System.out.println("Time = " + end);
        System.out.println("Memory = " + memory / 1048576);
    }
}
