package org.example.logic;

import org.example.model.*;

public class Multiply {
    public static Polynomial MultiplyPoly(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        for(Monomial m1: p1.getMonomials().values())
        {
            for(Monomial m2: p2.getMonomials().values())
            {
                double coefficient = m1.getCoefficient() * m2.getCoefficient();
                int exponent = m1.getExponent() + m2.getExponent();

                result.addMonomial(new Monomial(coefficient, exponent));
            }
        }
        return result;
    }
}
