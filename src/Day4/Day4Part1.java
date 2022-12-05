package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/home/bill/Documents/Java/Advent-of-Code-2022/src/Day4/input.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String strLine;
        int overlapCount = 0;
        int min1 = 0;
        int max1 = 0;
        int min2 = 0;
        int max2 = 0;

        while (sc.hasNextLine()) {
            try {
                strLine = sc.nextLine();
                String[] strArray = strLine.split("[-,]");
                min1 = Integer.parseInt(strArray[0]);
                max1 = Integer.parseInt(strArray[1]);
                min2 = Integer.parseInt(strArray[2]);
                max2 = Integer.parseInt(strArray[3]);
                if ((min1 <= min2 && max1 >= max2) || (min1 >= min2 && max1 <= max2)) overlapCount++;
            } catch (Exception e) {

            }
        }
        System.out.println("overlapCount: " + overlapCount);
    }
}
