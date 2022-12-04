package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/home/bill/Documents/Java/Advent-of-Code-2022/src/Day2/input.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        int score = 0;
        while (sc.hasNextLine()) {
            try {
                switch (sc.nextLine()) {
                    case "A X":
                        score += 4;
                        break;
                    case "B X":
                        score += 1;
                        break;
                    case "C X":
                        score += 7;
                        break;
                    case "A Y":
                        score += 8;
                        break;
                    case "B Y":
                        score += 5;
                        break;
                    case "C Y":
                        score += 2;
                        break;
                    case "A Z":
                        score += 3;
                        break;
                    case "B Z":
                        score += 9;
                        break;
                    case "C Z":
                        score += 6;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println(score);
    }
}
