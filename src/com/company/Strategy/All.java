package com.company.Strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class All implements SearchStrategy {

    @Override
    public Set<Integer> search(Map<String, List<Integer>> invertedIndex, String searchTerm ){
        String[] words = searchTerm.split(" ");
        Set<Integer> results = new HashSet<>();
        for (String word : words) {
            if (invertedIndex.get(word.toLowerCase()) != null) {
                if (results.isEmpty()) {
                    results.addAll(invertedIndex.get(word.toLowerCase()));
                } else {
                    results.retainAll(invertedIndex.get(word.toLowerCase()));
                }
            }
        }
        return results;
    }
}
