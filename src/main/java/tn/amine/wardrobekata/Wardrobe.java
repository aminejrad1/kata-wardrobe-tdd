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


    public static int calculate(List<Integer> combination) {
        int total = 0;

        for(int length: combination){
            total += length;
        }

        return  total;
    }
}
