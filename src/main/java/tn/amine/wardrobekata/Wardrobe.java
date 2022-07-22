package tn.amine.wardrobekata;

import org.paukov.combinatorics3.Generator;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Wardrobe {
    public static List<List<Integer>> findAllCombinations(List<Integer> lengths) {
        return Generator.combination(lengths)
                .multi(lengths.size())
                .stream()
                .collect(Collectors.toList());
    }

    public static int combine(List<Integer> combination) {
        int total = 0;

        for(int length: combination){
            total += length;
        }

        return  total;
    }

    public static List<List<Integer>> findCombinationsThatFit(List<List<Integer>> combinations, int length) {
        return combinations.stream().filter(combination -> combine(combination)==length).collect(Collectors.toList());
    }

    public static int calculatePrice(List<Integer> combination, HashMap<Integer, Integer> prices) {
        int total =0;
        for(int length: combination) {
            total += prices.get(length);
        }

        return total;
    }

    public static List<Integer> findCheapestOption(List<List<Integer>> combinationsThatFit, HashMap<Integer, Integer> prices) {
        int position = 0;
        int minimum = calculatePrice(combinationsThatFit.get(0), prices);

        for(int i=0; i<combinationsThatFit.size();i++){
            int temp = calculatePrice(combinationsThatFit.get(i), prices);

            if(temp<=minimum)
            {
                minimum = temp;
                position = i;
            }
        }

        return combinationsThatFit.get(position);
    }
}
