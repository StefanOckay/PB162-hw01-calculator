package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import cz.muni.fi.pb162.calculator.NumeralConverter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author jcechace
 */
public class ConvertingCalculatorTest {

    @Test
    public void isConverter() {
        Assert.assertTrue(NumeralConverter.class.isAssignableFrom(ConvertingCalculator.class));
    }

    @Test
    public void isCalculator() {
        Assert.assertTrue(Calculator.class.isAssignableFrom(ConvertingCalculator.class));
    }

    @Test
    public void hasImplementation() {
        Assert.assertTrue(ConvertingCalculator.class.isAssignableFrom(AdvancedCalculator.class));
    }
}
