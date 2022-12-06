package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

public class Day6Part2 {
    public static void main(String[] args) throws IOException {
        // read in input.txt as one continuous string
        String path = "/home/bill/Documents/Java/Advent-of-Code-2022/src/Day6/input.txt";
        Path filePath = Path.of(path);
        String inputStr = Files.readString(filePath);
        int startOfPacketMarker = 0;
        HashSet<Character> characterHashSet = new HashSet<>();

        // create a sliding window of four characters
        String window;
        windowingLoop:
        for (int i = 0; i < inputStr.length() - 13; i++) {
            characterHashSet.clear();
            startOfPacketMarker++;
            window = inputStr.substring(i, i + 14);
            // add each of the four characters in the window to a hash set and break out of the loop if all four characters in the window are unique
            for (int j = 0; j < window.length(); j++) {
                characterHashSet.add(window.charAt(j));
                if (characterHashSet.size() == 14) break windowingLoop;
            }
        }
        // must add thirteen to the startOfPacketMarker variable because a minimum of fourteen characters must initially be read into the window
        System.out.println((startOfPacketMarker + 13) + " characters must be processed until the first start-of-packet marker is found");
    }
}