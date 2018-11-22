package by.pvt.math;

import by.pvt.data.InputDataGenerate;
import by.pvt.service.AverageService;

import java.util.Arrays;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        AverageService averageService = ServiceLoader.load(AverageService.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Service not found"));

        int[] inputData = InputDataGenerate.generate(10, -100, 100);

        System.out.println(Arrays.toString(inputData));

        System.out.println(averageService.getMean(inputData));

    }
}
