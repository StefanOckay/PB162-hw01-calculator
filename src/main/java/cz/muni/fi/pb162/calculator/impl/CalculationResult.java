package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Result;

import static cz.muni.fi.pb162.calculator.Calculator.*;

/**
 * @author: Stefan Ockay
 */
public class CalculationResult implements Result {
    private double numeric = Double.NaN;
    private String alphanumeric = null;

    public CalculationResult(double numeric) {
        this.numeric = numeric;
    }

    public CalculationResult(String alphanumeric) {
        this.alphanumeric = alphanumeric;
    }

    @Override
    public boolean isSuccess() {
        if (alphanumeric == null) {
            return true;
        }
        if (getAlphanumericValue().equals(COMPUTATION_ERROR_MSG)) {
            return false;
        }
        if (getAlphanumericValue().equals(UNKNOWN_OPERATION_ERROR_MSG)) {
            return false;
        }
        if (getAlphanumericValue().equals(WRONG_ARGUMENTS_ERROR_MSG)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isAlphanumeric() {
        return alphanumeric != null;
    }

    @Override
    public boolean isNumeric() {
        return alphanumeric == null;
    }

    @Override
    public double getNumericValue() {
        return numeric;
    }

    @Override
    public String getAlphanumericValue() {
        return alphanumeric;
    }
}
