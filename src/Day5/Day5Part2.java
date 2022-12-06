package Day5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5Part2 {
    public static void main(String[] args) throws IOException {
        String path = "/home/bill/Documents/Java/Advent-of-Code-2022/src/Day5/input.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String strLine;

        // nine strings representing the starting arrangement of stacked crates (top of stack corresponds to index 0 of list)
        String stackStr1 = "NHSJFWTD";
        String stackStr2 = "GBNTQPRH";
        String stackStr3 = "VQL";
        String stackStr4 = "QRWSBN";
        String stackStr5 = "BMVTFDN";
        String stackStr6 = "RTHVBDM";
        String stackStr7 = "JQBD";
        String stackStr8 = "QHZRVJND";
        String stackStr9 = "SMHNB";

        // nine lists representing the stack of crates (characters) at any point in time
        ArrayList<Character> stack1 = new ArrayList<>();
        ArrayList<Character> stack2 = new ArrayList<>();
        ArrayList<Character> stack3 = new ArrayList<>();
        ArrayList<Character> stack4 = new ArrayList<>();
        ArrayList<Character> stack5 = new ArrayList<>();
        ArrayList<Character> stack6 = new ArrayList<>();
        ArrayList<Character> stack7 = new ArrayList<>();
        ArrayList<Character> stack8 = new ArrayList<>();
        ArrayList<Character> stack9 = new ArrayList<>();

        // add each character from the starting stack string to the list of crates
        for (int i = 0; i < stackStr1.length(); i++) {
            stack1.add(stackStr1.charAt(i));
        }
        for (int i = 0; i < stackStr2.length(); i++) {
            stack2.add(stackStr2.charAt(i));
        }
        for (int i = 0; i < stackStr3.length(); i++) {
            stack3.add(stackStr3.charAt(i));
        }
        for (int i = 0; i < stackStr4.length(); i++) {
            stack4.add(stackStr4.charAt(i));
        }
        for (int i = 0; i < stackStr5.length(); i++) {
            stack5.add(stackStr5.charAt(i));
        }
        for (int i = 0; i < stackStr6.length(); i++) {
            stack6.add(stackStr6.charAt(i));
        }
        for (int i = 0; i < stackStr7.length(); i++) {
            stack7.add(stackStr7.charAt(i));
        }
        for (int i = 0; i < stackStr8.length(); i++) {
            stack8.add(stackStr8.charAt(i));
        }
        for (int i = 0; i < stackStr9.length(); i++) {
            stack9.add(stackStr9.charAt(i));
        }

        // skipping the first 10 lines of input.txt
        for (int i = 0; i < 10; i++) sc.nextLine();

        // create a list of crate lists (corresponding to the entire loading dock)
        List<ArrayList<Character>> stackList = new ArrayList<>();
        stackList.add(stack1);
        stackList.add(stack2);
        stackList.add(stack3);
        stackList.add(stack4);
        stackList.add(stack5);
        stackList.add(stack6);
        stackList.add(stack7);
        stackList.add(stack8);
        stackList.add(stack9);

        // parse each line of the input text file starting with the moves on line 10
        while (sc.hasNext()) {
            strLine = sc.nextLine();
            String[] moveArray = strLine.split(" ");
            int numOfCratesMoved = Integer.parseInt(moveArray[1]);
            int startStack = Integer.parseInt(moveArray[3]) - 1;
            int endStack = Integer.parseInt(moveArray[5]) - 1;

            // insert crates at and remove crates from the beginning of the list as a group (corresponding to the top of the stack); however, the movement of crates here must be done one at a time
            for (int i = 0; i < numOfCratesMoved; i++) {
                stackList.get(endStack).add(0, stackList.get(startStack).get(numOfCratesMoved - 1 - i));
                stackList.get(startStack).remove(numOfCratesMoved - 1 - i);
            }
        }

        // construct and print the resulting string representing the top crate on each stack
        String answerString = "";
        for (int i = 0; i < stackList.size(); i++) answerString += stackList.get(i).get(0);
        System.out.println(answerString);
    }
}