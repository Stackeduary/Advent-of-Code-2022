package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/home/bill/Documents/Java/Advent-of-Code-2022/src/Day1/input.txt";
        File file = new File(path);
        String strLine;
        Scanner sc = new Scanner(file);
        int elfCalories = 0;
        ArrayList<Integer> topThreeElves = new ArrayList<Integer>();
        while (sc.hasNextLine()) {
            try {
                int calories = Integer.parseInt(sc.nextLine());
                elfCalories += calories;
            } catch (Exception e) {
                topThreeElves.add(elfCalories);
                elfCalories = 0;
            }
        }
        topThreeElves.sort(Comparator.reverseOrder());
        int sumTopThree = 0;
        sumTopThree = topThreeElves.get(0) + topThreeElves.get(1) + topThreeElves.get(2);
        System.out.println(sumTopThree);
    }
}