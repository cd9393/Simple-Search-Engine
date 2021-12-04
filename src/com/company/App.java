package com.company;

import java.util.Scanner;

public class App {
    public Scanner scanner;
    private Menu menu;

    public App() {
        scanner = new Scanner(System.in);
        menu = new Menu(scanner);
    }

    public void run() {
        int size = askUserForArraySize();
        String[] dataset = buildDataset(size);
        this.menu.run(dataset);
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

}
