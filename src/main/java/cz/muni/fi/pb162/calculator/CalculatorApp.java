package cz.muni.fi.pb162.calculator;

import cz.muni.fi.pb162.calculator.impl.ConvertingCalculator;
import cz.muni.fi.pb162.calculator.impl.AdvancedCalculator;

import java.util.Scanner;

/**
 * Class representing calculator
 *
 * @author jcechace
 */
public class CalculatorApp {

    /**
     * Command constant for exiting the program
     */
    public static final String EXIT_CMD = "exit";

    /**
     * Main program loop.
     * DO NOT MODIFY (or do, but if you break something, it will be on you :)
     *
     * @param args will be ignored
     */
    public static void main(String[] args) {
        System.out.println("Welcome to calculator app!\n");
        Scanner scanner = new Scanner(System.in, "utf-8");
        String line;
        boolean run = true;
        do {
            line = scanner.nextLine();
            if (EXIT_CMD.equals(line)) {
                run = false;
            } else {
                ConvertingCalculator calc = new AdvancedCalculator();
                Result result = calc.eval(line);
                if (result.isNumeric()) {
                    System.out.println(result.getNumericValue());
                } else {
                    System.out.println(result.getAlphanumericValue());
                }
            }
        } while(run);
    }
}
