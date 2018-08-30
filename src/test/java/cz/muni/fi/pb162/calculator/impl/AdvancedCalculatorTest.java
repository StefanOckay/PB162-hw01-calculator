package cz.muni.fi.pb162.calculator.impl;

import org.junit.Test;

/**
 * @author jcechace
 */
public class AdvancedCalculatorTest extends BasicCalculatorTest {

    @Override
    protected ConvertingCalculator getCalc() {
        return new AdvancedCalculator();
    }

    @Test
    public void numeralSystemsUpToHexSupported() {
        assertError("Base < 1 should not be supported", getCalc().fromDec(1, 1));
        assertError("Base < 1 should not be supported", getCalc().toDec(1, "1"));

    }

    @Test
    public void numeralSystemsUpFromBinarySupported() {
        assertError("Base > 16 should not be supported", getCalc().fromDec(17, 1));
        assertError("Base > 16 should not be supported", getCalc().toDec(17, "1"));
    }

    @Test
    public void invalidCharToDec() {
        assertError("#", getCalc().toDec(8, "#"));
    }

    @Test
    public void binToDec() {
        assertNumericResult("101110110 bin", 374, getCalc().toDec(2, "101110110"));
    }

    @Test
    public void decToBin() {
        assertAlphanumericResult("1342", "10100111110", getCalc().fromDec(2, 1342));
    }

    @Test
    public void octalToDec() {
        assertNumericResult("10110 oct", 5349, getCalc().toDec(8, "12345"));
    }

    @Test
    public void decToOctal() {
        assertAlphanumericResult("479705", "1650731", getCalc().fromDec(8, 479705));
    }

    @Test
    public void hexToDec() {
        assertNumericResult("AE134F hex", 11408207, getCalc().toDec(16, "AE134F"));
    }

    @Test
    public void decToHex() {
        assertAlphanumericResult("12243", "2FD3" , getCalc().fromDec(16, 12243));
    }
}
