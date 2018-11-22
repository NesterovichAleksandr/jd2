package by.pvt.data;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InputDataGenerateTest {

    @org.junit.Test
    public void generate() {
        assertNull(InputDataGenerate.generate(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertNull(InputDataGenerate.generate(-1, 0, 100));
        assertNotNull(InputDataGenerate.generate(0, 0, 100));

        Arrays.stream(InputDataGenerate.generate(100, 0, 100))
                .forEach(x -> {
                    assertTrue(0 <= x && x < 100);
                    System.out.println(x);
                });
    }
}