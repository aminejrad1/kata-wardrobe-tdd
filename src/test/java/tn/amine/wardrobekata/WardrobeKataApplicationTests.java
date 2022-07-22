package tn.amine.wardrobekata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
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
        assertEquals(200, Wardrobe.calculate(combination));
    }

    @Test
    void testGetAllCombinationThatFit() {
        assertNotEquals(0, Wardrobe.findCombinationsThatFit(Wardrobe.findAllCombinations(new ArrayList<>(Arrays.asList(50, 75, 100, 120))), 250).size());
        Wardrobe.findCombinationsThatFit(Wardrobe.findAllCombinations(new ArrayList<>(Arrays.asList(50, 75, 100, 120))), 250).forEach(System.out::println);
    }

}
