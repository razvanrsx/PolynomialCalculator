package org.example.logic;

import org.example.model.*;

public class Add {
    public static Polynomial addPoly(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();

        for(Monomial m: p1.getMonomials().values())
        {
            result.addMonomial(m);
        }

        for(Monomial m: p2.getMonomials().values())
        {
           result.addMonomial(m);
        }
        return result;
    }

}
