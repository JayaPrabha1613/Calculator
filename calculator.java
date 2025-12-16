import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame implements ActionListener {
    JTextField text;
    String operator;
    double num1, num2, result;

    calculator() {
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        text = new JTextField();
        text.setEditable(false);
        text.setFont(new Font("Arial", Font.BOLD, 24));
        add(text, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 4, 5, 5));

        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+",
            "C","←","sin","cos",
            "tan","log","ln","sqrt",
            "x^2","x^y","1/x","pi",
            "e","exp","abs","mod"
        };

        for (String b : buttons) {
            JButton btn = new JButton(b);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.matches("[0-9\\.]")) {
                text.setText(text.getText() + command);
            } else if (command.equals("C")) {
                text.setText("");
            } else if (command.equals("←")) {
                String t = text.getText();
                if (t.length() > 0) text.setText(t.substring(0, t.length()-1));
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(text.getText());
                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num1 / num2; break;
                    case "x^y": result = Math.pow(num1, num2); break;
                    case "mod": result = num1 % num2; break;
                }
                text.setText(String.valueOf(result));
            } else if (command.equals("sin")) {
                double val = Math.sin(Math.toRadians(Double.parseDouble(text.getText())));
                text.setText(String.valueOf(val));
            } else if (command.equals("cos")) {
                double val = Math.cos(Math.toRadians(Double.parseDouble(text.getText())));
                text.setText(String.valueOf(val));
            } else if (command.equals("tan")) {
                double val = Math.tan(Math.toRadians(Double.parseDouble(text.getText())));
                text.setText(String.valueOf(val));
            } else if (command.equals("log")) {
                double val = Math.log10(Double.parseDouble(text.getText()));
                text.setText(String.valueOf(val));
            } else if (command.equals("ln")) {
                double val = Math.log(Double.parseDouble(text.getText()));
                text.setText(String.valueOf(val));
            } else if (command.equals("sqrt")) {
                double val = Math.sqrt(Double.parseDouble(text.getText()));
                text.setText(String.valueOf(val));
            } else if (command.equals("x^2")) {
                double val = Math.pow(Double.parseDouble(text.getText()), 2);
                text.setText(String.valueOf(val));
            } else if (command.equals("1/x")) {
                double val = 1 / Double.parseDouble(text.getText());
                text.setText(String.valueOf(val));
            } else if (command.equals("pi")) {
                text.setText(String.valueOf(Math.PI));
            } else if (command.equals("e")) {
                text.setText(String.valueOf(Math.E));
            } else if (command.equals("exp")) {
                double val = Math.exp(Double.parseDouble(text.getText()));
                text.setText(String.valueOf(val));
            } else if (command.equals("abs")) {
                double val = Math.abs(Double.parseDouble(text.getText()));
                text.setText(String.valueOf(val));
            } else {
                operator = command;
                num1 = Double.parseDouble(text.getText());
                text.setText("");
            }
        } catch (Exception ex) {
            text.setText("Error");
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}
