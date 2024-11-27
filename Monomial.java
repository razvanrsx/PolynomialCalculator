package org.example.model;

public class Monomial {
    private double coefficient;
    private int exponent;

    public Monomial(double coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        if (coefficient == 0) {
            return "";
        }

        String coefficientStr = "";
        if (coefficient == 1.0 && exponent != 0) {
            coefficientStr = "";
        } else if (coefficient == -1.0 && exponent != 0) {
            coefficientStr = "-";
        } else {
            coefficientStr = String.valueOf(coefficient);
        }

        String exponentStr = "";
        if (exponent == 1) {
            exponentStr = "x";
        } else if (exponent > 1) {
            exponentStr = "x^" + exponent;
        }
        return coefficientStr + exponentStr;
    }

}
