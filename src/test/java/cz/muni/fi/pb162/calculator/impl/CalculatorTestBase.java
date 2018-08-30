package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import cz.muni.fi.pb162.calculator.Result;
import org.junit.Assert;

/**
 * @author jcechace
 */
public abstract class CalculatorTestBase {
    public static final double DELTA = 0.00001;

    protected abstract Calculator getCalc();

    protected void assertNumericResult(String message, double expected, Result actual) {
        Assert.assertTrue("Calculation should be successful", actual.isSuccess());
        Assert.assertTrue("Result should be numeric", actual.isNumeric());
        Assert.assertFalse("Result should not be alphanumeric", actual.isAlphanumeric());
        Assert.assertEquals(message, expected, actual.getNumericValue(), DELTA);
        Assert.assertEquals("Wrong alphanumeric value", null, actual.getAlphanumericValue());
    }

    protected void assertAlphanumericResult(String message, String expected, Result actual) {
        Assert.assertTrue("Calculation should be successful", actual.isSuccess());
        Assert.assertFalse("Result should not be numeric", actual.isNumeric());
        Assert.assertTrue("Result should be alphanumeric", actual.isAlphanumeric());
        Assert.assertEquals(message, expected, actual.getAlphanumericValue());
        Assert.assertEquals("Wrong numeric value", Double.NaN, actual.getNumericValue(), DELTA);
    }

    protected void assertError(String message,String expected, Result actual) {
        Assert.assertFalse("Calculation should not be successful", actual.isSuccess());
        Assert.assertFalse("Result should not be numeric", actual.isNumeric());
        Assert.assertTrue("Result should be alphanumeric", actual.isAlphanumeric());
        Assert.assertEquals(message, expected, actual.getAlphanumericValue());
        Assert.assertEquals("Wrong numeric value", Double.NaN, actual.getNumericValue(), DELTA);
    }

    protected void assertError(String message, Result actual) {
        assertError(message, Calculator.COMPUTATION_ERROR_MSG, actual);
    }
}
