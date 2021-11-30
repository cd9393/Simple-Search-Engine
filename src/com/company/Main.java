package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            String[] inputArray = getInput(scanner);
            String searchTerm = scanner.nextLine();
            searchInput(inputArray, searchTerm);
        }
    }

    public static String[] getInput(Scanner scanner) {
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        return inputArray;
    }

    public static void searchInput(String[] inputArray, String searchTerm) {
        boolean isFound = false;
        for (int i =0; i < inputArray.length; i++) {
            if (searchTerm.equals(inputArray[i])) {
                System.out.println(i + 1);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Not found");
        }
    }
}
