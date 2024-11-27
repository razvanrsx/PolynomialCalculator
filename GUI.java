package org.example.gui;

import org.example.logic.*;
import org.example.model.Polynomial;


import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JTextField polynomial1Field;
    private JTextField polynomial2Field;
    private JTextField resultField;
    private JTextField derivativeField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton deriveButton;

    public GUI() {
        setTitle("Calculator Polinoame");
        setSize(800, 600);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        polynomial1Field = new JTextField();
        polynomial2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        derivativeField = new JTextField();
        derivativeField.setPreferredSize(new Dimension(50, 24));

        addButton = new JButton("Adunare");
        subtractButton = new JButton("Scădere");
        multiplyButton = new JButton("Înmulțire");
        deriveButton = new JButton("Derivare");

        polynomial1Field.setPreferredSize(new Dimension(200, 24));
        polynomial2Field.setPreferredSize(new Dimension(200, 24));
        resultField.setPreferredSize(new Dimension(200, 24));

        addButton.setPreferredSize(new Dimension(100, 100));
        subtractButton.setPreferredSize(new Dimension(100, 100));
        multiplyButton.setPreferredSize(new Dimension(100, 100));
        deriveButton.setPreferredSize(new Dimension(100, 100));

        gbc.weightx = 1;
        add(new JLabel("Polinom 1:"), gbc);
        add(polynomial1Field, gbc);
        add(new JLabel("Polinom 2:"), gbc);
        add(polynomial2Field, gbc);


        add(new JLabel("Derivează(p1/p2):"), gbc);
        add(derivativeField, gbc);

        add(new JLabel("Rezultat:"), gbc);
        add(resultField, gbc);

        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        add(addButton, gbc);
        add(subtractButton, gbc);
        add(multiplyButton, gbc);
        add(deriveButton, gbc);

        setVisible(true);


        addButton.addActionListener(e -> {
            Polynomial p1 = ConvertToPolynomial.ConvertPoly(polynomial1Field.getText());
            Polynomial p2 = ConvertToPolynomial.ConvertPoly(polynomial2Field.getText());
            Polynomial result = Add.addPoly(p1, p2);
            resultField.setText(result.toString());
        });

        subtractButton.addActionListener(e -> {
            Polynomial p1 = ConvertToPolynomial.ConvertPoly(polynomial1Field.getText());
            Polynomial p2 = ConvertToPolynomial.ConvertPoly(polynomial2Field.getText());
            Polynomial result = Subtract.SubtractPoly(p1, p2);
            resultField.setText(result.toString());
        });


        multiplyButton.addActionListener(e -> {
            Polynomial p1 = ConvertToPolynomial.ConvertPoly(polynomial1Field.getText());
            Polynomial p2 = ConvertToPolynomial.ConvertPoly(polynomial2Field.getText());
            Polynomial result = Multiply.MultiplyPoly(p1, p2);
            resultField.setText(result.toString());
        });

        deriveButton.addActionListener(e -> {
            String derivativeChoice = derivativeField.getText();
            Polynomial result = null;
            if ("p1".equals(derivativeChoice)) {
                Polynomial p = ConvertToPolynomial.ConvertPoly(polynomial1Field.getText());
                result = Derive.DerivePoly(p);
            } else if ("p2".equals(derivativeChoice)) {
                Polynomial p = ConvertToPolynomial.ConvertPoly(polynomial2Field.getText());
                result = Derive.DerivePoly(p);
            }

            if (result != null) {
                resultField.setText(result.toString());
            } else {
                resultField.setText("");
            }
        });




    }
}

