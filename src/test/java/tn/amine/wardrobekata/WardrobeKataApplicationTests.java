package tn.amine.wardrobekata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest
class WardrobeKataApplicationTests {

    @Test
    void testFindAllPossibleCombinations() {
        List<Integer> lengths = new ArrayList<>(Arrays.asList(50, 75));
        assertEquals(3, Wardrobe.findAllCombinations(lengths).size());
    }

    @Test
    void testCalculateCombinationTotalLength() {
        List<Integer> combination = new ArrayList<>(Arrays.asList(50, 50, 50, 50));
        assertEquals(200, Wardrobe.combine(combination));
    }

    @Test
    void testGetAllCombinationThatFit() {
        assertNotEquals(0, Wardrobe.findCombinationsThatFit(Wardrobe.findAllCombinations(new ArrayList<>(Arrays.asList(50, 75, 100, 120))), 250).size());
        Wardrobe.findCombinationsThatFit(Wardrobe.findAllCombinations(new ArrayList<>(Arrays.asList(50, 75, 100, 120))), 250).forEach(System.out::println);
    }

    @Test
    void testCalculateCombinationPrice() {
        HashMap<Integer, Integer> prices = new HashMap<Integer, Integer>() {{
            put(50, 59);
            put(75, 62);
            put(100, 90);
            put(120, 111);
        }};

        assertEquals(236, Wardrobe.calculatePrice(new ArrayList<>(Arrays.asList(50, 50, 50, 50)), prices));
    }

    @Test
    void testFindCheapestCombinationFromCombinationsThatFitWall() {
        List<List<Integer>> combinationsThatFit = Wardrobe.findCombinationsThatFit(Wardrobe.findAllCombinations
                (new ArrayList<>(Arrays.asList(50, 75, 100, 120))), 250);

        HashMap<Integer, Integer> prices = new HashMap<Integer, Integer>() {{
            put(50, 59);
            put(75, 62);
            put(100, 90);
            put(120, 111);
        }};

        assertEquals(new ArrayList<>(Arrays.asList(50, 50, 75, 75)), Wardrobe.findCheapestOption(combinationsThatFit, prices));
    }
}
