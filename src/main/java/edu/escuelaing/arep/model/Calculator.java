package edu.escuelaing.arep.model;

public class Calculator {

    public static double fahrenheit_To_Celsius(double number){
        number = number -32;
        number = number *5;
        number = number /9;
        return number;
    }
}
