package com.company;

import java.util.*;

public class App {
    public Scanner scanner;
    private Menu menu;
    private List<String> dataset;
    private Map<String, List<Integer>> invertedIndex;

    public App() {
       this.scanner = new Scanner(System.in);
       this.menu = new Menu(scanner);
       this.dataset = new ArrayList<>();
       this.invertedIndex = new HashMap<>();
    }

    public App(List<String> dataset, Map<String, List<Integer>> invertedIndex) {
        this.scanner = new Scanner(System.in);
        this.menu = new Menu(scanner);
        this.dataset = dataset;
        this.invertedIndex = invertedIndex;
    }

    public void run() {
        this.menu.run(dataset, invertedIndex);
    }
}
