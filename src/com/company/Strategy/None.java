package com.company.Strategy;

import java.util.*;

public class None implements SearchStrategy {

    @Override
    public Set<Integer> search(Map<String, List<Integer>> invertedIndex, String searchTerm) {
        List<String> words = new ArrayList<>(Arrays.asList(searchTerm.toLowerCase().split(" ")));
        Set<Integer> setForMissingElements = new HashSet<>();
        Set<Integer> setForPresentedElements = new HashSet<>();

        for (Map.Entry<String, List<Integer>> entry : invertedIndex.entrySet()) {
            if (!words.contains(entry.getKey())) {
                setForMissingElements.addAll(entry.getValue());
            } else {
                setForPresentedElements.addAll(entry.getValue());
            }
        }
        setForMissingElements.removeAll(setForPresentedElements);
        return setForMissingElements;
    }
}
