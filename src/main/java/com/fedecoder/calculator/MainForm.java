package com.fedecoder.calculator;

import com.fedecoder.calculator.operations.*;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;


public class MainForm {

    private JPanel panelMain;
    private JButton btnSeven;
    private JButton btnEight;
    private JButton btnNine;
    private JButton btnFour;
    private JButton btnFive;
    private JButton btnSix;
    private JButton btnOne;
    private JButton btnTwo;
    private JButton btnThree;
    private JButton btnMultiply;
    private JButton btnSubtract;
    private JButton btnAddition;
    private JButton btnDivide;
    private JButton btnZero;
    private JButton btnResult;
    private JButton btnReset;
    private JLabel lblDigital;
    private boolean operatorAdded = false;
    private boolean endCalculator = false;

    public MainForm() {
        addNumberAction(btnOne);
        addNumberAction(btnTwo);
        addNumberAction(btnThree);
        addNumberAction(btnFour);
        addNumberAction(btnFive);
        addNumberAction(btnSix);
        addNumberAction(btnSeven);
        addNumberAction(btnEight);
        addNumberAction(btnNine);
        addNumberAction(btnZero);
        addNumberAction(btnMultiply);
        addNumberAction(btnAddition);
        addNumberAction(btnDivide);
        addNumberAction(btnSubtract);

        btnReset.addActionListener(e -> {
            lblDigital.setText("0");
            operatorAdded = false;
            endCalculator = false;
        });

        btnResult.addActionListener(e -> {
            lblDigital.setText(String.valueOf(constructTerminus(lblDigital.getText()).calculate()));
            endCalculator = true;
        });
    }

    public void Initialize() {
        FlatDarculaLaf.setup();
        JFrame frame = new JFrame("Calculator - v1.0.0");
        frame.setContentPane(new MainForm().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("image/icon.png")));
        frame.pack();
        frame.setSize(350, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void addNumberAction(JButton button) {
        button.addActionListener(e -> {
            if(!endCalculator) {
                if (lblDigital.getText().equals("0")) {
                    lblDigital.setText(button.getText());
                } else {
                    if (lblDigital.getText().length() < 15) {
                        if ((button.getText().equals("+") || button.getText().equals("x") || button.getText().equals("-") || button.getText().equals("÷")) && !operatorAdded) {
                            operatorAdded = true;
                            lblDigital.setText(lblDigital.getText() + button.getText());
                        } else if (!button.getText().equals("+") && !button.getText().equals("x") && !button.getText().equals("-") && !button.getText().equals("÷")) {
                            lblDigital.setText(lblDigital.getText() + button.getText());
                        }
                    }
                }
            }
        });
    }

    private Terminus constructTerminus(String expression) {
        String[] terminus;

        if (expression.contains("x")) {
            terminus = expression.split("x");
            return new Multiply(new Operating(Double.parseDouble(terminus[0])), new Operating(Double.parseDouble(terminus[1])));
        } else if (expression.contains("+")) {
            terminus = expression.split("\\+");
            return new Addition(new Operating(Double.parseDouble(terminus[0])), new Operating(Double.parseDouble(terminus[1])));
        } else if (expression.contains("-")) {
            terminus = expression.split("-");
            return new Subtract(new Operating(Double.parseDouble(terminus[0])), new Operating(Double.parseDouble(terminus[1])));
        } else if (expression.contains("÷")) {
            terminus = expression.split("÷");
            return new Divide(new Operating(Double.parseDouble(terminus[0])), new Operating(Double.parseDouble(terminus[1])));
        } else {
            return new Operating(Double.parseDouble(expression));
        }
    }
}
