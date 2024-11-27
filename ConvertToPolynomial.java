package org.example.logic;
import org.example.model.Monomial;
import org.example.model.Polynomial;

public class ConvertToPolynomial {

    public static Polynomial ConvertPoly(String input) {
        Polynomial polynomial = new Polynomial();
        input = input.replaceAll("\\s", "").replaceAll("-", "+-");
        if (input.startsWith("+-")) {
            input = input.substring(1);
        }
        String[] terms = input.split("\\+");

        for (String term : terms) {
            if (term.isEmpty()) continue;

            double coefficient = 1.0;
            int exponent = 0;

            if (term.equals("-")) {
                coefficient = -1.0;
            } else if (term.contains("x")) {
                String[] parts = term.split("x\\^?");
                if (parts.length > 0 && !parts[0].isEmpty()) {
                    if (!parts[0].equals("-")) {
                        coefficient = Double.parseDouble(parts[0]);
                    } else {
                        coefficient = -1.0; //
                    }
                }
                exponent = parts.length == 2 ? Integer.parseInt(parts[1]) : 1;
            } else {
                coefficient = Double.parseDouble(term);
            }

            Monomial monomial = new Monomial(coefficient, exponent);
            polynomial.addMonomial(monomial);
        }

        return polynomial;
    }



}
