package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private File file;

    public FileReader(File file) {
        this.file = file;
    }

    public List<String> readContactsFromFile() throws FileNotFoundException {
        List<String> contacts = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                contacts.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found:");
        }
        return contacts;
    }
}
