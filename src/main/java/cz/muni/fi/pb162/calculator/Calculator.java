package cz.muni.fi.pb162.calculator;

/**
 * Interface with basic operations which should be supported by every calculator.
 *
 * @author jcechace
 */
public interface Calculator {

    /**
     * Error constant for computation error
     */
    String COMPUTATION_ERROR_MSG = "COMPUTATION ERROR";

    /**
     * Error constant for unknown operation
     */
    String UNKNOWN_OPERATION_ERROR_MSG = "UNKNOWN OPERATION";

    /**
     * Error constant for wrong argument
     */
    String WRONG_ARGUMENTS_ERROR_MSG = "WRONG ARGUMENTS";

    /**
     * Command constant for {@link #sum(double, double)}
     */
    String SUM_CMD = "+";

    /**
     * Command constant for {@link #sub(double, double)}
     */
    String SUB_CMD = "-";

    /**
     * Command constant for {@link #mul(double, double)}
     */
    String MUL_CMD = "*";

    /**
     * Command constant for {@link #div(double, double)}
     */
    String DIV_CMD = "/";

    /**
     * Command constant for {@link #fac(int)}
     */
    String FAC_CMD = "!";

    /**
     * Evaluate textual input and perform computation
     * @param input input string
     * @return result
     */
    Result eval(String input);

    /**
     * Computes the sum of two numbers (x + y)
     *
     * @param x first number
     * @param y second number
     * @return result
     */
    Result sum(double x, double y);

    /**
     * Subtract two numbers (x - y)
     * @param x first number
     * @param y second number
     * @return result
     */
    Result sub(double x, double y);

    /**
     * Multiply two number (x * y(
     * @param x first number
     * @param y second number
     * @return result
     */
    Result mul(double x, double y);

    /**
     * Calculate the division of two numbers (x / y)
     * @param x first number
     * @param y second number
     * @return result
     */
    Result div(double x, double y);

    /**
     * Computes the factorial of given number;
     * We guarantee that the result for all tested inputs will fit into double;
     *
     * @param x input number
     * @return result
     */
    Result fac(int x);

}
