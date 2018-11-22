package by.pvt.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AverageServiceImpl implements AverageService {

    public double getMean(int[] inputData) {

        if (inputData == null) {
            throw new InvalidParameterException("Input data cannot be null");
        }
        return Arrays.stream(inputData)
                .average()
                .orElse(Double.NaN);
    }

    @Override
    public int[] getMode(int[] inputData) {
        if (inputData == null) {
            throw new InvalidParameterException("Input data cannot be null");
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(inputData[0], 1);
        for (int i = 1; i < inputData.length; i++) {
            if (hashMap.containsKey(inputData[i])) {
                Integer value = hashMap.get(inputData[i]);
                hashMap.replace(inputData[i], ++value);
            } else {
                hashMap.put(inputData[i], 1);
            }
        }
        int maximalCount = 1;
        ArrayList<Integer> modeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> currentEntry : hashMap.entrySet()) {
            if (currentEntry.getValue() > maximalCount) {
                modeList.clear();
                modeList.add(currentEntry.getKey());
                maximalCount = currentEntry.getValue();
            } else if (!modeList.contains(currentEntry.getKey())
                    && currentEntry.getValue() == maximalCount
                    && currentEntry.getValue() != 1) {
                modeList.add(currentEntry.getKey());
            }
        }
        int size = modeList.size();
        int[] mode = new int[size];
        for (int i = 0; i < size; i++) {
            mode[i] = modeList.get(i);
        }
        return mode;
    }

    @Override
    public double getMedian(int[] inputData) {
        if (inputData == null) {
            throw new InvalidParameterException("Input data cannot be null");
        }
        Arrays.sort(inputData);
        int length = inputData.length;
        if (length % 2 == 1) {
            return inputData[length / 2];
        } else {
            return (inputData[length / 2] + inputData[length / 2 - 1]) / 2.0;
        }
    }
}
