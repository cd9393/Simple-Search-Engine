package com.company;

import com.company.Strategy.All;
import com.company.Strategy.Any;
import com.company.Strategy.None;
import com.company.Strategy.SearchStrategy;

import java.util.*;

public class Menu {
    Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run(List<String> dataset, Map<String, List<Integer>> invertedIndex) {
        boolean isRunning = true;

        while(isRunning) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    findPerson(dataset, invertedIndex);
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

    public void findPerson(List<String> dataset,Map<String, List<Integer>> invertedIndex ) {
        String strategy = getStrategy();
        Set<Integer> indexes = new HashSet<>();
        String searchQuery = getSearchQuery();
        switch (strategy) {
            case "ALL":
                indexes = new All().search(invertedIndex, searchQuery);
                break;
            case "ANY":
                indexes = new Any().search(invertedIndex, searchQuery);
                break;
            case "NONE":
                indexes = new None().search(invertedIndex, searchQuery);
                break;
            default:
                break;
        }
        List<String> results = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        indexList.addAll(indexes);
            for (int lineNumber : indexList) {
                results.add(dataset.get(lineNumber));
            }
        outPutSearchResults(results);
    }

    private String getStrategy() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String strategy = scanner.nextLine().toLowerCase();
        return strategy;
    }

    private String getSearchQuery() {
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
