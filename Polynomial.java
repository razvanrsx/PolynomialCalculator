package org.example.model;
import java.util.Map;
import java.util.Comparator;
import java.util.TreeMap;

public class Polynomial {
    private Map<Integer, Monomial> monomials;

    public Polynomial()
    {
        monomials = new TreeMap<>(Comparator.reverseOrder());
    }

    public Map<Integer, Monomial> getMonomials() {
        return monomials;
    }

    public void addMonomial(Monomial monomial) {
        monomials.merge(monomial.getExponent(), monomial, (existing, newMonomial) ->
                new Monomial(existing.getCoefficient() + newMonomial.getCoefficient(), monomial.getExponent())
        );
    }
    @Override

    public String toString() {
        if (monomials.isEmpty()) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        for (Monomial monomial : monomials.values()) {
            if (monomial.getCoefficient() == 0) continue;
            if (builder.length() > 0) {
                if (monomial.getCoefficient() > 0) {
                    builder.append(" + ");
                } else {
                    builder.append(" - ");
                    monomial = new Monomial(Math.abs(monomial.getCoefficient()), monomial.getExponent());

                }
            } else if (monomial.getCoefficient() < 0) {
                builder.append("-");
                monomial = new Monomial(Math.abs(monomial.getCoefficient()), monomial.getExponent());
            }
            builder.append(monomial.toString());
        }

        return builder.toString();
    }


}
