package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import cz.muni.fi.pb162.calculator.Result;

/**
 * @author: Stefan Ockay
 */
public class BasicCalculator implements Calculator {

    @Override
    public Result eval(String input) {
        String[] parts = input.split(" ");
        if (parts.length == 2) {
            if (!parts[0].equals(FAC_CMD)) {
                return new CalculationResult(UNKNOWN_OPERATION_ERROR_MSG);
            }
            try {
                int x = Integer.parseInt(parts[1]);
                return fac(x);
            } catch (NumberFormatException ex) {
                return new CalculationResult(COMPUTATION_ERROR_MSG);
            }
        }
        if (parts.length == 3) {
            try {
                double x = Double.parseDouble(parts[1]);
                double y = Double.parseDouble(parts[2]);
                if (parts[0].equals(SUM_CMD)) {
                    return sum(x, y);
                }
                if (parts[0].equals(SUB_CMD)) {
                    return sub(x, y);
                }
                if (parts[0].equals(MUL_CMD)) {
                    return mul(x, y);
                }
                if (parts[0].equals(DIV_CMD)) {
                    return div(x, y);
                }
            } catch (NumberFormatException ex) {
                return new CalculationResult(COMPUTATION_ERROR_MSG);
            }
        }
        return new CalculationResult(UNKNOWN_OPERATION_ERROR_MSG);
    }

    @Override
    public Result sum(double x, double y) {
        return new CalculationResult(x + y);
    }

    @Override
    public Result sub(double x, double y) {
        return new CalculationResult(x - y);
    }

    @Override
    public Result mul(double x, double y) {
        return new CalculationResult(x * y);
    }

    @Override
    public Result div(double x, double y) {
        if (y == 0) {
            return new CalculationResult(COMPUTATION_ERROR_MSG);
        } else {
            return new CalculationResult(x / y);
        }
    }

    @Override
    public Result fac(int x) {
        if (x < 0) {
            return new CalculationResult(COMPUTATION_ERROR_MSG);
        }
        int fact = 1;
        for (int i = x; i > 1; i--) {
            fact *= i;
        }
        return new CalculationResult((double)fact);
    }
}
