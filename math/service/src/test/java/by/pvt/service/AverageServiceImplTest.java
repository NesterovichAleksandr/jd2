package by.pvt.service;

import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AverageServiceImplTest {

    @Test
    public void getMean() {

        AverageService averageService = new AverageServiceImpl();

        try {
            averageService.getMean(null);
        } catch (Exception e) {
            assertEquals(e.getClass(), InvalidParameterException.class);
        }
        assertEquals(0.0, averageService.getMean(new int[]{0, 0, 0, 0}), 0.0);
        assertEquals(1.5, averageService.getMean(new int[]{1, 2}), 0.0);
    }

    @Test
    public void getMedian() {
        AverageService averageService = new AverageServiceImpl();
        try {
            averageService.getMedian(null);
        } catch (Exception e) {
            assertEquals(e.getClass(), InvalidParameterException.class);
        }
        assertEquals(290, averageService.getMedian(new int[]{275, 286, 250, 290, 296, 315, 325}), 0.0);
        assertEquals(25.5, averageService.getMedian(new int[]{30, 5, 23, 5, 28, 30}), 0.0);
        assertEquals(30, averageService.getMedian(new int[]{30}), 0.0);
        assertEquals(17.5, averageService.getMedian(new int[]{30, 5}), 0.0);
    }

    @Test
    public void getMode() {
        AverageService averageService = new AverageServiceImpl();
        try {
            averageService.getMode(null);
        } catch (Exception e) {
            assertEquals(e.getClass(), InvalidParameterException.class);
        }
        assertEquals("[5, 30]", Arrays.toString(averageService.getMode(new int[]{30, 5, 23, 5, 28, 30})));
        assertEquals("[45]", Arrays.toString(averageService.getMode(new int[]{38, 42, 36, 45, 48, 45, 45, 42, 40, 47, 39})));
        assertEquals("[]", Arrays.toString(averageService.getMode(new int[]{275, 286, 250, 290, 296, 315, 325})));
    }
}