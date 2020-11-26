package Calculator;

import Calculator.DigitButtonListener;
import Calculator.SubmitButtonListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Calculator");
        setBounds(100, 100, 300, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        add(top, BorderLayout.PAGE_START);
        top.setLayout(new BorderLayout());


        JPanel bottom = new JPanel();
        add(bottom, BorderLayout.CENTER);
        bottom.setLayout(new GridLayout(5, 3));

        JTextField inputField = new JTextField();
        inputField.setFont(new Font("TimesRoman", Font.BOLD, 30));

        DigitButtonListener digitButtonListener = new DigitButtonListener(inputField);
        SubmitButtonListener submitButtonListener = new SubmitButtonListener(inputField);
        CleanButtonListener cleanButtonListener = new CleanButtonListener(inputField);


        for (int i = 0; i < 10; i++) {
            top.add(inputField, BorderLayout.CENTER);
            JButton btn = new JButton(String.valueOf(i));
            btn.setFont(new Font("TimesRoman", Font.BOLD, 30));
            btn.addActionListener(digitButtonListener);
            bottom.add(btn);
        }


        //
        JButton submit = new JButton("=");
        submit.setFont(new Font("TimesRoman", Font.BOLD, 30));
        submit.addActionListener(submitButtonListener);
        bottom.add(submit);
        //
        JButton plus = new JButton("+");
        plus.setFont(new Font("TimesRoman", Font.BOLD, 30));
        plus.addActionListener(digitButtonListener);
        bottom.add(plus);
        //
        JButton minus = new JButton("-");
        minus.setFont(new Font("TimesRoman", Font.BOLD, 30));
        minus.addActionListener(digitButtonListener);
        bottom.add(minus);
        //
        JButton multiply = new JButton("*");
        multiply.setFont(new Font("TimesRoman", Font.BOLD, 30));
        multiply.addActionListener(digitButtonListener);
        bottom.add(multiply);
        //
        JButton divide = new JButton("/");
        divide.setFont(new Font("TimesRoman", Font.BOLD, 30));
        divide.addActionListener(digitButtonListener);
        bottom.add(divide);
        //
        JButton clean = new JButton("C");
        clean.setFont(new Font("TimesRoman", Font.BOLD, 30));
        clean.addActionListener(cleanButtonListener);
        top.add(clean, BorderLayout.EAST);
        //
        setVisible(true);
    }
}
