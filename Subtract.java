package org.example.logic;

import org.example.model.*;
public class Subtract {
    public static Polynomial SubtractPoly(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        for(Monomial m: p1.getMonomials().values())
        {
            result.addMonomial(m);
        }

        for(Monomial m: p2.getMonomials().values())
        {
            Monomial negativeMon = new Monomial(-m.getCoefficient(), m.getExponent());
            result.addMonomial(negativeMon);
            // scaderea este adunare cu semn schimbat
            // schimbam semnul celui de-al doilea polinom,
            // si il adaugam la rezultat
        }
        return result;
    }
}
