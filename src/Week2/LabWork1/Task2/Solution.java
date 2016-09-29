package Week2.LabWork1.Task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Inontran on 29.09.2016.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();

        BufferedReader fileReader = new BufferedReader(new FileReader("race.in"));

        int n = 0;
        if (fileReader.ready()) n = Integer.parseInt(fileReader.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) strings[i] = fileReader.readLine();

        List<Team> list = new ArrayList<>();
        String currentCountry = "";
        String currentSportman = "";
        for (int i = 0; i < n; i++)
        {
            currentCountry = strings[i].split(" ")[0];
            currentSportman = strings[i].split(" ")[1];
            if (!list.contains(new Team(currentCountry)))
            {
                Team team = new Team(currentCountry);
                team.listOfSportman.add(currentSportman);
                list.add(team);
            }
            else
            {
                list.get(list.indexOf(new Team(currentCountry))).listOfSportman.add(currentSportman);
            }
        }

        list = mergeSort(list);


        BufferedWriter writer = new BufferedWriter(new FileWriter("race.out"));
        for (int i = 0; i < list.size(); i++) {
            writer.write( String.valueOf("=== " + list.get(i).country + " ===") );
            writer.write(System.lineSeparator());
            for (int j = 0; j < list.get(i).listOfSportman.size(); j++)
            {
                writer.write( list.get(i).listOfSportman.get(j) );
                writer.write(System.lineSeparator());
            }
        }

        if (fileReader!=null) fileReader.close();
        if (writer!=null) writer.close();


        long end = System.currentTimeMillis() - start;
//        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memory = Runtime.getRuntime().totalMemory();
        System.out.println("Time = " + end);
        System.out.println("Memory = " + memory / 1048576);
    }


    public static List<Team> mergeSort(List<Team> a)
    {
        if (a.size() <=1) return a;
        int m = a.size()/2;
        List<Team> aL = a.subList(0, m);
        List<Team> aR =  a.subList(m, a.size());
        aL = mergeSort(aL);
        aR = mergeSort(aR);
        return merge(aL, aR);
    }

    private static ArrayList<Team> merge(List<Team> a, List<Team> b)
    {
        int i = 0, j = 0;
        ArrayList<Team> ans = new ArrayList<>();
        while (i < a.size() && j < b.size())
        {
            if (j >= b.size() || (i < a.size() && a.get(i).country.compareTo( b.get(j).country ) < 0) )
            {
                ans.add(a.get(i));
                i++;
            }
            else
            {
                ans.add(b.get(j));
                j++;
            }
        }
        for ( ; j < b.size(); ) ans.add(b.get(j++));
        for ( ; i < a.size(); ) ans.add(a.get(i++));
        return ans;
    }

    public static class Team
    {
        String country;
        ArrayList<String> listOfSportman = new ArrayList<>();

        public Team(String country) {
            this.country = country;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Team)) return false;

            Team team = (Team) o;

            return country != null ? country.equals(team.country) : team.country == null;

        }

        @Override
        public int hashCode() {
            return country != null ? country.hashCode() : 0;
        }
    }
}
