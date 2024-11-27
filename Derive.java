package org.example.logic;

import org.example.model.*;
public class Derive {
    public static Polynomial DerivePoly(Polynomial p)
    {
        Polynomial result = new Polynomial();
        for(Monomial m: p.getMonomials().values())
        {
            if(m.getExponent() != 0)
            {
                double derivCoeff = m.getCoefficient() * m.getExponent();
                int derivExp = m.getExponent() - 1;
                result.addMonomial(new Monomial(derivCoeff, derivExp));
            }
        }

        return result;
    }
}
