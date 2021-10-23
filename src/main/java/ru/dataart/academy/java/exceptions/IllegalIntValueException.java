package ru.dataart.academy.java.exceptions;

public class IllegalIntValueException extends RuntimeException{
    public IllegalIntValueException(){}
    public IllegalIntValueException(String message){
        super(message);
    }
}
