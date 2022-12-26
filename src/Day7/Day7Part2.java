package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day7Part2 {
    static final int TOTAL_DISK_SPACE = 70000000;
    static final int DISK_SPACE_NEEDED = 30000000;

    public static void main(String[] args) throws FileNotFoundException {
        List<DirectoryTree> allDirectories = new ArrayList<>();
        DirectoryTree root = new DirectoryTree("/");
        DirectoryTree current = root;

        String path = "/home/bill/Documents/Java/Advent-of-Code-2022/src/Day7/input.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        int dirSize = 0;
        String strLine;
        while (sc.hasNextLine()) {
            strLine = sc.nextLine();
            String[] wordArray = strLine.split(" ");
            if (wordArray[0].equals("$")) {
                // skip these lines as they don't tell us anything actionable about directory sizes
                if (strLine.equals("$ ls") || strLine.equals("$ cd /")) {
                    continue;
                }
                if (strLine.equals("$ cd ..")) {
                    // get parent directory
                    current = current.getParent();
                }
                else {
                    // cd into <dirName>
                    DirectoryTree dir = new DirectoryTree(wordArray[2]);
                    dir.setParent(current);
                    current.getChildren().add(dir);
                    current = dir;
                    allDirectories.add(dir);
                }
            }
            // the only other two possibilities are dir <dirName> and <number> <fileName>
            // ignore dir <dirName> because we don't care about a directory unless we cd into it
            else {
                // lines starting with a number are files, so set the current directory's size to that numeric value
                if (wordArray[0].chars().allMatch(Character::isDigit)) {
                    current.setSize(current.getSize() + Integer.parseInt(wordArray[0]));
                }
            }
        }
        int freeDiskSpace = TOTAL_DISK_SPACE - root.getDirSize();
        int requiredDiskSpace = DISK_SPACE_NEEDED - freeDiskSpace;
        int smallestDirToDelete = TOTAL_DISK_SPACE;
        for (DirectoryTree dt : allDirectories) {
            dirSize = dt.getDirSize();
            if (dirSize > requiredDiskSpace && dirSize < smallestDirToDelete) smallestDirToDelete = dirSize;
        }
        System.out.println("Smallest directory to delete to free up enough disk space for the update: " + smallestDirToDelete);
    }
}