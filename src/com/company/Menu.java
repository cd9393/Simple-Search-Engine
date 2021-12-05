package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run(List<String> dataset) {
        boolean isRunning = true;

        while(isRunning) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    findPerson(dataset);
                    break;
                case 2:
                    printAllPeople(dataset);
                    break;
                case 0:
                    isRunning = false;
                    System.out.println();
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }
    }

    private void printAllPeople(List<String> dataset) {
        for (String person : dataset) {
            System.out.println(person);
        }
    }

    public void findPerson(List<String> dataset) {
        String searchQuery = getSearchQuery();
        List<String> results = new ArrayList<>();
        for (String item : dataset) {
            if (item.toLowerCase().contains(searchQuery.toLowerCase())) {
                results.add(item);
            }
        }
        outPutSearchResults(results);
    }

    public String getSearchQuery() {
        System.out.println();
        System.out.println("Enter a name or email to search all suitable people.");
        String searchTerm = scanner.nextLine();
        return searchTerm;
    }

    public void outPutSearchResults(List<String> results) {
        System.out.println();
        System.out.println("=== List of people ===");
        if (results.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            for(String person : results) {
                System.out.println(person);
            }
        }
    }

    public void displayMenu() {
        System.out.println();
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }
}
