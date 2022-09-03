import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {
    public static void main(final String args[]) {
        new Converter();
    }
}

public class Converter {
    // Final keyword makes it constant
    final JFrame myFrame;
    final JButton myButton;
    final JTextField textField;
    Converter() {
        myFrame = new JFrame();
        myButton = new JButton("Convert!");
        textField = new JTextField();
        myButton.setBounds(50, 50, 150, 20);
        textField.setBounds(50, 100, 95, 30);
        myButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("Hi, lets go convert some money!!");
            }
        });
        myFrame.add(myButton);
        myFrame.add(textField);
        myFrame.setSize(400, 400);
        myFrame.setLayout(null);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
