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
        Scanner sc = new Scanner(file);
        int elfCalories = 0;
        ArrayList<Integer> allElves = new ArrayList<Integer>();
        while (sc.hasNextLine()) {
            try {
                int calories = Integer.parseInt(sc.nextLine());
                elfCalories += calories;
            } catch (Exception e) {
                allElves.add(elfCalories);
                elfCalories = 0;
            }
        }
        allElves.sort(Comparator.reverseOrder());
        int sumTopThree = allElves.get(0) + allElves.get(1) + allElves.get(2);
        System.out.println(sumTopThree);
    }
}