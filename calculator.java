import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MathTool extends JFrame {
    JButton btnAdd, btnSub, btnMul, btnDiv;
    JTextField field1, field2;
    JLabel lblResult, lblNum1, lblNum2;

    MathTool() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        lblNum1 = new JLabel("Enter Number 1:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblNum1, gbc);

        field1 = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(field1, gbc);

        lblNum2 = new JLabel("Enter Number 2:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(lblNum2, gbc);

        field2 = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(field2, gbc);

        btnMul = new JButton("Multiply");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnMul, gbc);

        btnDiv = new JButton("Divide");
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(btnDiv, gbc);

        btnAdd = new JButton("Add");
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(btnAdd, gbc);

        btnSub = new JButton("Subtract");
        gbc.gridx = 3;
        gbc.gridy = 2;
        add(btnSub, gbc);

        lblResult = new JLabel("Result:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        add(lblResult, gbc);

        ButtonHandler handler = new ButtonHandler();
        btnMul.addActionListener(handler);
        btnDiv.addActionListener(handler);
        btnAdd.addActionListener(handler);
        btnSub.addActionListener(handler);
    }

    class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double val1, val2;

            try {
                val1 = Double.parseDouble(field1.getText());
            } catch (NumberFormatException ex) {
                lblResult.setText("Invalid input for Number 1");
                lblResult.setForeground(Color.CYAN);
                return;
            }

            try {
                val2 = Double.parseDouble(field2.getText());
            } catch (NumberFormatException ex) {
                lblResult.setText("Invalid input for Number 2");
                lblResult.setForeground(Color.MAGENTA);
                return;
            }

            String action = e.getActionCommand();

            switch (action) {
                case "Add":
                    lblResult.setText(val1 + " + " + val2 + " = " + (val1 + val2));
                    lblResult.setForeground(Color.BLUE);
                    break;
                case "Subtract":
                    lblResult.setText(val1 + " - " + val2 + " = " + (val1 - val2));
                    lblResult.setForeground(Color.ORANGE);
                    break;
                case "Multiply":
                    lblResult.setText(val1 + " * " + val2 + " = " + (val1 * val2));
                    lblResult.setForeground(Color.GREEN);
                    break;
                case "Divide":
                    if (val2 == 0) {
                        lblResult.setText("Cannot divide by zero");
                        lblResult.setForeground(Color.RED);
                    } else {
                        lblResult.setText(val1 + " / " + val2 + " = " + (val1 / val2));
                        lblResult.setForeground(Color.PINK);
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        MathTool app = new MathTool();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setTitle("Simple Calculator");
        app.setSize(600, 300);
        app.setVisible(true);
    }
}
