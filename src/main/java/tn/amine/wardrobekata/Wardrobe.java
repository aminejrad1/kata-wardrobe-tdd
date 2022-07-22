package tn.amine.wardrobekata;

import org.paukov.combinatorics3.Generator;

import java.util.List;
import java.util.stream.Collectors;

public class Wardrobe {
    public static List<List<Integer>> findAllCombinations(List<Integer> lengths) {
        return Generator.combination(lengths)
                .multi(lengths.size())
                .stream()
                .collect(Collectors.toList());
    }
}
