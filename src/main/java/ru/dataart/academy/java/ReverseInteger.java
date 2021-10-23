package ru.dataart.academy.java;

import ru.dataart.academy.java.exceptions.IllegalIntValueException;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        ArrayList<Long> currList = new ArrayList<>();
        long operableVal = Math.abs((long) inputNumber);
        while (true) {
            if (operableVal > 0) {
                currList.add((operableVal % 10));
                operableVal /= 10;
            } else break;
        }
        long resultVal = 0;
        for (int i = 0; i < currList.size(); i++) {
            resultVal += currList.get(i) * Math.pow(10, currList.size() - 1 - i);
        }
        if (resultVal > Integer.MAX_VALUE || resultVal < Integer.MIN_VALUE) {
            throw new IllegalIntValueException("Operation result is out of int values range");
        }
        return (int) (inputNumber > 0 ? resultVal : -resultVal);
    }
}
