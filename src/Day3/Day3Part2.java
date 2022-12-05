package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day3Part2 {
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

        // calculate the item priority and total priority of each triple in the input file
        while (sc.hasNextLine()) {
            try {
                // read in a triplet of lines from the input text file
                String stringOne = sc.nextLine();
                String stringTwo = sc.nextLine();
                String stringThree = sc.nextLine();

                // create a set of the items for each elf
                HashSet<Character> elfOne = new HashSet<>();
                HashSet<Character> elfTwo = new HashSet<>();
                HashSet<Character> elfThree = new HashSet<>();

                // add each character of each string to a hash set
                for (int i = 0; i < stringOne.length(); i++) {
                    elfOne.add(stringOne.charAt(i));
                }
                for (int i = 0; i < stringTwo.length(); i++) {
                    elfTwo.add(stringTwo.charAt(i));
                }
                for (int i = 0; i < stringThree.length(); i++) {
                    elfThree.add(stringThree.charAt(i));
                }

                // find the intersection of items in all three hash sets and get its priority value
                HashSet<Character> intersection = new HashSet<>(elfOne);
                intersection.retainAll(elfTwo);
                intersection.retainAll(elfThree);
                char charOverlap = (char) intersection.toArray()[0];
                itemPriority = charMapping.get(charOverlap);
            } catch (Exception e) {
                itemPriority = 0; // if there is no overlap between the two compartments
            }
            priority += itemPriority;
        }
        System.out.println("The sum of the priorities is: " + priority);
        }
}