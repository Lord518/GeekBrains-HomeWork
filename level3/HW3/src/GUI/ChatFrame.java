package GUI;

import RecordingMessage.InOutMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.function.Consumer;

public class ChatFrame extends JFrame {
    private StringBuilder stringBuilder;
    private JTextArea textArea;
    private ActionListener submitListener;


    public ChatFrame(Consumer<String> transmitter) {
        stringBuilder = new StringBuilder();

        setTitle("Chat.server.Chat Frame v1.0.0");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                JFrame frame = (JFrame)e.getSource();

                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to exit the application?",
                        "Exit Application",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION){
                    Thread t = new Thread(() ->InOutMessage.doWriterMessages(textArea.getText(),true));
                    t.start();
                    while (t.isAlive());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }

            }
        });
        setBounds(new Rectangle(150, 150, 400, 700));

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        top.add(textArea, BorderLayout.CENTER);

        add(top, BorderLayout.CENTER);

        TextField textField = new TextField();
        JButton jButton = new JButton("Submit");
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        bottom.add(textField, BorderLayout.CENTER);
        bottom.add(jButton, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);

        submitListener = new SubmitActionListener(textField, transmitter);
        jButton.addActionListener(submitListener);
        textField.addActionListener(submitListener);

        setVisible(true);
    }

    public void append(String message) {
        stringBuilder.append(textArea.getText())
                .append("\n")
                .append(message);
        textArea.setText(stringBuilder.toString());
        stringBuilder.setLength(0);
    }


}

