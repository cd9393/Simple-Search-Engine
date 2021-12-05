package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if ("--data".equals(args[0])) {
            File file = new File(args[1]);
            List<String> contacts = new FileReader(file).readContactsFromFile();
            App app = new App(contacts);
            app.run();
        } else {
            App app = new App();
            app.run();
        }
    }
}
