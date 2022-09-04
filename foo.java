import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class foo {
    public static void main(String[] args) {
        new Converter();
    }
}

class Converter extends JFrame implements KeyListener {
    double CONV_RATE = 79.79;
    JLabel from = new JLabel(" ");
    JTextField textField = new JTextField(6);
    JLabel label = new JLabel("         ");

    public Converter() {
        this.setLayout(new FlowLayout());
        this.add(from);
        this.add(textField);
        this.add(label);
        textField.addKeyListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 100);
        this.setVisible(true);
    }

    void setTextOnLabel() {
        String amountString = "";
        double amount = Double.parseDouble(textField.getText());
        amountString += (int) (amount * CONV_RATE) + " rupees";
        label.setText(amountString);
    }

    public void keyReleased(KeyEvent k) {
        setTextOnLabel();
    }

    public void keyPressed(KeyEvent k) {
        // Do Nothing;
    }

    public void keyTyped(KeyEvent k) {
        // Do Nothing;
    }
}
