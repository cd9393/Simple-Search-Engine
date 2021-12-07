package com.company.Strategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SearchStrategy {

    Set<Integer> search(Map<String, List<Integer>> invertedIndex, String searchTerm );

}
