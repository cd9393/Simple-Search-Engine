package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
Scanner scanner;
    public App() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        int size = askUserForArraySize();
        String[] dataset = buildDataset(size);
        int queryCount = getSearchQueryCount();
        for (int i = 0; i < queryCount; i++) {
            searchDataset(dataset);
        }
    }

    public int askUserForArraySize() {
        System.out.println("Enter the number of people:");
        int size = Integer.parseInt(scanner.nextLine());
        return size;
    }

    public String[] buildDataset(int size) {
        String[] dataset = new String[size];
        System.out.println("Enter all people:");
        for (int i = 0; i < size; i++) {
            dataset[i] = scanner.nextLine();
        }
        return dataset;
    }

    public int getSearchQueryCount() {
        System.out.println("Enter the number of search queries:");
        int queryCount = Integer.parseInt(scanner.nextLine());
        return queryCount;
    }

    public void searchDataset(String[] dataset) {
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
        System.out.println("Enter data to search people:");
        String searchTerm = scanner.nextLine();
        return searchTerm;
    }

    public void outPutSearchResults(List<String> results) {
        if (results.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println("Found people:");
            for(String person : results) {
                System.out.println(person);
            }
        }
    }
}
