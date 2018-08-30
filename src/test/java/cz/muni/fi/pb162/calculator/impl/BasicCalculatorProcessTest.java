package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import org.junit.Test;

/**
 * @author jcechace
 */
public class BasicCalculatorProcessTest extends CalculatorTestBase {

    protected String cmd(String operator, String... operands) {
        StringBuilder builder = new StringBuilder(operator);
        for (String operand : operands) {
            builder.append(" ").append(operand);
        }
        return builder.toString();
    }


    @Override
    protected Calculator getCalc() {
        return new BasicCalculator();
    }

    @Test
    public void unknownOperation() {
        assertError("'aaa' is not a know operation", Calculator.UNKNOWN_OPERATION_ERROR_MSG, getCalc().eval("aaa"));
    }

    @Test
    public void multiplication() {
        String cmd = cmd(Calculator.MUL_CMD, "4", "2");
        assertNumericResult(cmd, 8, getCalc().eval(cmd));
    }

    @Test
    public void division() {
        String cmd = cmd(Calculator.DIV_CMD, "4", "2");
        assertNumericResult(cmd, 2, getCalc().eval(cmd));
    }

    @Test
    public void factorial() {
        String cmd = cmd(Calculator.FAC_CMD, "4");
        assertNumericResult(cmd, 24, getCalc().eval(cmd));
    }

    @Test
    public void sum() {
        String cmd = cmd(Calculator.SUM_CMD, "4", "2");
        assertNumericResult(cmd, 6, getCalc().eval(cmd));
    }

    @Test
    public void subtraction() {
        String cmd = cmd(Calculator.SUB_CMD, "4", "2");
        assertNumericResult(cmd, 2, getCalc().eval(cmd));
    }
}
