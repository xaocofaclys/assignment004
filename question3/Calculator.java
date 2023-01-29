package question3;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {

    private JTextField displayField;
    private JButton[] buttons;
    private String[] labels = {
        "Backspace", "", "", "CE", "C", "7", "8", "9", "/", "sqrt",
        "4", "5", "6", "*", "%", "1", "2", "3", "-", "1/x",
        "0", "+/-", ".", "+", "=",
    };
    private boolean[] operations = {
        false, false, false, false, false, false, false, false, true, true,
        false, false, false, true, true, false, false, false, true, true,
        false, true, false, true, true,
    };
    private double result = 0;
    private String operator = "=";
    private boolean startOfNumber = true;

    public Calculator() {
        displayField = new JTextField(35);
        displayField.setText("0.0");
        displayField.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 5, 3, 3));
        buttons = new JButton[labels.length];

        for (int i = 0; i < labels.length; i++) {
            buttons[i] = new JButton(labels[i]);
            buttonPanel.add(buttons[i]);
        }

        ActionListener numberListener = new NumberListener();
        ActionListener operatorListener = new OperatorListener();

        for (int i = 0; i < labels.length; i++) {
            if (operations[i]) {
                buttons[i].addActionListener(operatorListener);
            } else {
                buttons[i].addActionListener(numberListener);
            }
        }

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(5, 5));
        content.add(displayField, BorderLayout.NORTH);
        content.add(buttonPanel, BorderLayout.CENTER);
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setContentPane(content);
        this.pack();
        this.setTitle("Calculator");
        this.setResizable(false);
    }

    public static void main(String[] args) {
        JFrame frame = new Calculator();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void performOperation(double number) {
        if (operator.equals("+")) {
            result += number;
        } else if (operator.equals("-")) {
            result -= number;
        } else if (operator.equals("*")) {
            result *= number;
        } else if (operator.equals("/")) {
            result /= number;
        } else if (operator.equals("=")) {
            result = number;
        }
        displayField.setText("" + result);
    }

    private class NumberListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (startOfNumber) {
                displayField.setText(command);
            } else {
                displayField.setText(displayField.getText() + command);
            }
            startOfNumber = false;
        }
    }

    private class OperatorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (startOfNumber) {
                if (command.equals("-")) {
                    displayField.setText(command);
                    startOfNumber = false;
                } else {
                    operator = command;
                }
            } else {
                double number = Double.parseDouble(displayField.getText());
                performOperation(number);
                operator = command;
                startOfNumber = true;
            }
        }
    }
}

