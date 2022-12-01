package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/home/bill/Documents/Java/Advent-of-Code-2022/src/Day1/input.txt";
        File file = new File(path);
        String strLine;
        Scanner sc = new Scanner(file);
        int maxCalories = 0;
        int elfCalories = 0;
        while (sc.hasNextLine()) {
            try {
                int calories = Integer.parseInt(sc.nextLine());
                elfCalories += calories;
            } catch (Exception e) {
                if (elfCalories > maxCalories) {
                    maxCalories = elfCalories;
                }
                elfCalories = 0;
            }
        }
        System.out.println(maxCalories);
    }
}
