package Week2.LabWork1.Task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Inontran on 01.10.2016.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("antiqs.in"));
        int n = Integer.parseInt(fileReader.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = i+1;
        array = transposition(0, n-1, array);
        for (int i = 0; i < n; i++) System.out.print(array[i] + " ");

        if (fileReader!=null) fileReader.close();
    }

    public static int[] transposition(int left, int right, int[] a)
    {
        if (a.length <=1 ) return a;
        int key = (left + right) / 2;
        int temp;
        temp = a[key];
        a[key] = a[a.length-1];
        a[a.length-1] = temp;
        int[] aL = Arrays.copyOfRange(a, left, key);
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
}
