package tn.amine.wardrobekata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WardrobeKataApplicationTests {

    @Test
    void testFindAllPossibleCombinations() {
        List<Integer> lengths = new ArrayList<>(Arrays.asList(50, 75));
        assertEquals(3, Wardrobe.findAllCombinations(lengths).size());
    }
}
