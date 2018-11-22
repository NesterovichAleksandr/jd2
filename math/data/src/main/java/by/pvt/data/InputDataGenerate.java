package by.pvt.data;

import java.util.Random;

public class InputDataGenerate {

    public static int[] generate(int arrayLength, int minElementValue, int maxElementValue) {

        if (arrayLength == Integer.MAX_VALUE
                || minElementValue == Integer.MIN_VALUE
                || maxElementValue == Integer.MAX_VALUE
                || arrayLength < 0) {
            return null;
        }

        return new Random()
                .ints(arrayLength, minElementValue, maxElementValue)
                .toArray();
    }
}
