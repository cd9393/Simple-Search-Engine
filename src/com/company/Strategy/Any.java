package com.company.Strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Any implements SearchStrategy {

    @Override
   public Set<Integer> search(Map<String, List<Integer>> invertedIndex, String searchTerm ){
        String[] words = searchTerm.toLowerCase().split(" ");
        Set<Integer> result = new HashSet<>();
        for (String word : words) {
            if (invertedIndex.containsKey(word)) {
                result.addAll(invertedIndex.get(word));
            }
        }
        return result;
    }
}
