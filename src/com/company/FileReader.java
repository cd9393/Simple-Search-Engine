package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    public Map<String, List<Integer>> buildInvertedIndex(List<String> contacts) {
        Map<String, List<Integer>> invertedIndexMap = new HashMap<>();
        String[] allWordsInFile = getAllWordsInFile(contacts);
        for (String word : allWordsInFile) {
            List<Integer> indexes = findLinesWhichContainString(contacts, word);
            invertedIndexMap.put(word,indexes);
        }
        return invertedIndexMap;
    }

    private String[] getAllWordsInFile(List<String> contacts) {
        StringBuilder allContacts = new StringBuilder();
        for (String contact : contacts) {
            allContacts.append(contact.toLowerCase());
            allContacts.append(" ");
        }
        return allContacts.toString().split(" ");
    }

    private List<Integer> findLinesWhichContainString(List<String> contacts,String searchTerm) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).toLowerCase().contains(searchTerm.toLowerCase())) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
