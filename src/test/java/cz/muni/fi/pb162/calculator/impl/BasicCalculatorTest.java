package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import org.junit.Test;

/**
 * @author jcechace
 */
public class BasicCalculatorTest extends CalculatorTestBase {

    @Override
    protected Calculator getCalc() {
        return new BasicCalculator();
    }

    @Test
    public void multiplication() {
        assertNumericResult("4*2", 8, getCalc().mul(4, 2));
    }

    @Test
    public void division() {
        assertNumericResult("4/2", 2, getCalc().div(4, 2));
    }

    @Test
    public void divisionByZero() {
        assertError("Division by zero should fail", getCalc().div(4, 0));
    }

    @Test
    public void factorial() {
        assertNumericResult("4!", 24, getCalc().fac(4));
    }

    @Test
    public void factorialOfZero() {
        assertNumericResult("0!", 1, getCalc().fac(0));
    }

    @Test
    public void factorialOfNegativeNumber() {
        assertError("(-7)!", getCalc().fac(-7));
    }

    @Test
    public void sum() {
        assertNumericResult("4+2", 6, getCalc().sum(4, 2));
    }

    @Test
    public void subtraction() {
        assertNumericResult("4-2", 2, getCalc().sub(4, 2));
    }
}
