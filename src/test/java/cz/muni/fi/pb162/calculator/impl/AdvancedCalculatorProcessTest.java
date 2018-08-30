package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import cz.muni.fi.pb162.calculator.NumeralConverter;
import org.junit.Test;

/**
 * @author jcechace
 */
public class AdvancedCalculatorProcessTest extends BasicCalculatorProcessTest {

    @Override
    protected Calculator getCalc() {
        return new AdvancedCalculator();
    }

    @Test
    public void fromDec() {
        String cmd = cmd(NumeralConverter.FROM_DEC_CMD, "2", "1342");
        assertAlphanumericResult(cmd, "10100111110", getCalc().eval(cmd));
    }

    @Test
    public void toDec() {
        String cmd = cmd(NumeralConverter.TO_DEC_CMD, "2", "10100111110");
        assertNumericResult(cmd, 1342, getCalc().eval(cmd));
    }
}
