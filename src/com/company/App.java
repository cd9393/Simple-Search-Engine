package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public Scanner scanner;
    private Menu menu;
    private List<String> dataset;

    public App() {
       this.scanner = new Scanner(System.in);
       this.menu = new Menu(scanner);
       this.dataset = new ArrayList<>();
    }

    public App(List<String> dataset) {
        this.scanner = new Scanner(System.in);
        this.menu = new Menu(scanner);
        this.dataset = dataset;
    }

    public void run() {
        this.menu.run(dataset);
    }
}
