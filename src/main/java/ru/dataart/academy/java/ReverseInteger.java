package ru.dataart.academy.java;

import ru.dataart.academy.java.exceptions.IllegalIntValueException;

import java.util.*;

public class ReverseInteger {
    /**
     * @param inputNumber - any integer value
     * @return - inputNumber in reversed order
     * Example: 1234 -> 4321
     * -23 -> -32
     * 120 -> 21
     * -2,147,483,648 -> exception and error message
     * If result (number in reversed order) is out of int range [-2,147,483,648,  2,147,483,647] throw custom
     * unchecked exception. In main method (Main class) if exception happened output message with problem to user.
     */
    public int reverse(int inputNumber) {
        List<Long> reverseIntAsList = getReverseIntAsList(inputNumber);
        long reverseVal = getValueFromList(reverseIntAsList);
        if (!isWithinInt(reverseVal)) {
            throw new IllegalIntValueException("Operation result is out of int values range");
        }
        return (int) (inputNumber > 0 ? reverseVal : -reverseVal);
    }

    private List<Long> getReverseIntAsList(int valToReverse) {
        ArrayList<Long> resultList = new ArrayList<>();
        long operableVal = Math.abs((long) valToReverse);
        while (true) {
            if (operableVal > 0) {
                resultList.add((operableVal % 10));
                operableVal /= 10;
            } else {
                break;
            }
        }
        return resultList;
    }
    
    private long getValueFromList(List<Long> valueList){
        long resultVal = 0;
        for (int i = 0; i < valueList.size(); i++) {
            resultVal += valueList.get(i) * Math.pow(10, valueList.size() - 1 - i);
        }
        return resultVal;
    }

    private boolean isWithinInt(long val) {
        return val <= Integer.MAX_VALUE && val >= Integer.MIN_VALUE;
    }
}
