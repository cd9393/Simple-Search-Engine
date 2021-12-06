package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if ("--data".equals(args[0])) {
            File file = new File(args[1]);
            FileReader fileReader = new FileReader(file);
            List<String> contacts = fileReader.readContactsFromFile();
            Map<String, List<Integer>> invertedIndex = fileReader.buildInvertedIndex(contacts);
            App app = new App(contacts, invertedIndex);
            app.run();
        } else {
            App app = new App();
            app.run();
        }
    }
}
