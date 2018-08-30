package cz.muni.fi.pb162.calculator;

/**
 * Interface for class allowing conversions from and to decimal system.
 *
 * WARING: you have to actually implement the required algorithms yourself.
 * This means that the use of any library methods which allow the conversion
 * is not allowed (e.g. Integer.toBinaryString(x), Integer.valueOf(x, base))
 *
 * @author jcechace
 */
public interface NumeralConverter {
    /**
     *  Digit characters for numeral base 2-16
     */
    String DIGITS = "0123456789ABCDEF";

    /**
     * Command constant for {@link #toDec(int, String)}
     */
    String TO_DEC_CMD = ">dec";

    /**
     * Command constant for {@link #fromDec(int, int)}
     */
    String FROM_DEC_CMD = "dec>";

    /**
     * Convert a number in arbitrary numeral system (up to base 16) to decimal
     * @param base base of source numeral system (e.g. 2 for binary)
     * @param number number in source numeral system
     * @return result with numeric value set
     */
    Result toDec(int base, String number);

    /**
     * Convert a number from decimal system to any other numeral system (up to base 16)
     * @param base base of target numeral system (e.g. 2 for binary)
     * @param number number in decimal numeral system
     * @return result with alphanumeric value set
     */
    Result fromDec(int base, int number);
}
