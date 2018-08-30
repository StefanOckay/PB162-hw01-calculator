package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Result;

/**
 * @author: Stefan Ockay
 */
public class AdvancedCalculator extends BasicCalculator implements ConvertingCalculator {

    @Override
    public Result eval(String input) {
        String[] parts = input.split(" ");
        if (!parts[0].equals(TO_DEC_CMD) && !parts[0].equals(FROM_DEC_CMD)) {
            return super.eval(input);
        }
        if (parts.length == 3) {
            try {
                int base = Integer.parseInt(parts[1]);
                if (parts[0].equals(TO_DEC_CMD)) {
                    String number = parts[2];
                    return toDec(base, number);
                }
                if (parts[0].equals(FROM_DEC_CMD)) {
                    int number = Integer.parseInt(parts[2]);
                    return fromDec(base, number);
                }
            } catch (NumberFormatException ex) {
                return new CalculationResult(COMPUTATION_ERROR_MSG);
            }
        }
        return new CalculationResult(WRONG_ARGUMENTS_ERROR_MSG);
    }

    private int getDecVal(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F')) {
            return Character.getNumericValue(c);
        }
        return -1;
    }

    @Override
    public Result toDec(int base, String number) {
        if (base < 2 || base > 16) {
            return new CalculationResult(COMPUTATION_ERROR_MSG);
        }
        int result = 0;
        int decPower = 1;
        int decVal;
        for (int i = number.length() - 1; i >= 0; i--) {
            if ((decVal = getDecVal(number.charAt(i))) == -1) {
                return new CalculationResult(COMPUTATION_ERROR_MSG);
            }
            result += decVal * decPower;
            decPower *= base;
        }
        return new CalculationResult((double) result);
    }

    private char getCharVal(int number) {
        if (number >= 0 && number <= 9) {
            return (char)('0' + number);
        }
        if (number >= 10 && number <= 15) {
            return (char)('A' + number - 10);
        }
        return '-';
    }

    @Override
    public Result fromDec(int base, int number) {
        if (base < 2 || base > 16) {
            return new CalculationResult(COMPUTATION_ERROR_MSG);
        }
        StringBuilder buffer = new StringBuilder();
        while (number > 0) {
            buffer.append(getCharVal(number % base));
            number = number / base;
        }
        StringBuilder revBuffer = buffer.reverse();
        return new CalculationResult(revBuffer.toString());
    }
}
