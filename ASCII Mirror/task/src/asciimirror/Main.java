package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> unmodifiedList = readInput();
        assert unmodifiedList != null;
        String longestStringPath = findLongestStringLength(unmodifiedList);
        List<String> modifiedList = normalizeStringsLength(unmodifiedList, longestStringPath);

        List<String> reversedList = reverse(modifiedList);

        printResults(modifiedList, reversedList);
    }

    private static List<String> readInput() {
        System.out.println("Input the file path:");
        String filePath = scanner.nextLine();

        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            List<String> unmodifiedList = new ArrayList<>();
            while (fileScanner.hasNextLine()) {
                unmodifiedList.add(fileScanner.nextLine());
            }
            fileScanner.close();
            return unmodifiedList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return null;
        }
    }

    private static String findLongestStringLength(List<String> inputList) {
        int stringLength = 0;
        for (String s : inputList) {
            if (s.length() > stringLength) {
                stringLength = s.length();
            }
        }

        return String.valueOf(stringLength);
    }

    private static List<String> normalizeStringsLength(List<String> inputList, String longestStringPath) {
        List<String> modifiedList = new ArrayList<>(inputList);

        for (int i = 0; i < modifiedList.size(); i++) {
            if (modifiedList.get(i).length() < Integer.parseInt(longestStringPath)) {
                int lengthDifference = Integer.parseInt(longestStringPath) - modifiedList.get(i).length();
                modifiedList.set(i, modifiedList.get(i) + " ".repeat(Math.max(0, lengthDifference)));
            }
        }

        return modifiedList;
    }

    private static List<String> reverse(List<String> list) {

        List<String> reverseList = new ArrayList<>();
        for (String s : list) {
            StringBuilder reverseLine = new StringBuilder();
            for (int j = s.length() - 1; j >= 0; j--) {
                char ch = reverseChar(s.charAt(j));
                reverseLine.append(ch);
            }
            reverseList.add(reverseLine.toString());
        }
        return reverseList;
    }

    private static char reverseChar(char ch) {
        switch (ch) {
            case '<' -> ch = '>';
            case '>' -> ch = '<';
            case '(' -> ch = ')';
            case ')' -> ch = '(';
            case '{' -> ch = '}';
            case '}' -> ch = '{';
            case '[' -> ch = ']';
            case ']' -> ch = '[';
            case '/' -> ch = '\\';
            case '\\' -> ch = '/';
            default -> {
            }
        }
        return ch;
    }

    private static void printResults(List<String> modifiedList, List<String> reversedList) {
        for (int i = 0; i < modifiedList.size(); i++) {
            System.out.println(modifiedList.get(i) + " | " + reversedList.get(i));
        }
    }
}