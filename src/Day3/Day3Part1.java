package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day3Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/home/bill/Documents/Java/Advent-of-Code-2022/src/Day3/input.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        int priority = 0;
        int itemPriority = 0;

        // create a HashMap with the priority values of each character
        String allChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<Character, Integer> charMapping = new HashMap<>();
        for (int i = 0; i < allChars.length(); i++) {
            charMapping.put(allChars.charAt(i), i + 1);
        }

        // calculate the item priority and total priority of each line in the input file
        String strLine;
        while (sc.hasNextLine()) {
            try {
                strLine = sc.nextLine();

                // create a set of the items in the first compartment
                HashSet<Character> firstCompartment = new HashSet<>();
                for (int i = 0; i < strLine.length() / 2; i++) {
                    firstCompartment.add(strLine.charAt(i));
                }

                // create a set of the items in the second compartment
                HashSet<Character> secondCompartment = new HashSet<>();
                for (int j = strLine.length() / 2; j < strLine.length(); j++) {
                    secondCompartment.add(strLine.charAt(j));
                }

                // find the intersection of items in both compartments and get its priority value
                firstCompartment.retainAll(secondCompartment);
                char charOverlap = (char) firstCompartment.toArray()[0];
                itemPriority = charMapping.get(charOverlap);
            } catch (Exception e) {
                itemPriority = 0; // if there is no overlap between the two compartments
            }
            priority += itemPriority;
        }
        System.out.println("The sum of the priorities is: " + priority);
    }
}