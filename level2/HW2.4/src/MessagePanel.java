import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//pull-request

public class MessagePanel {
    private JPanel panel;
    private JButton send;
    private JTextField message;
    private JTextArea buffer;

    public MessagePanel(JTextArea b) {
        panel = new JPanel();
        this.buffer = b;
        init();

    }

    public JPanel getPanel() {
        return panel;
    }

    private void init()
    {
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(message());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(sendButton(), BorderLayout.EAST);

    }
    private JTextField message(){
        message = new JTextField(1);
        message.setFont(new Font("TimesRoman", Font.BOLD, 20));
        message.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER)
                        {
                          buffer.setText(buffer.getText()+"Stas : "+message.getText()+"\n");
                          message.setText("");}
                       }
                }
        );
        return message;
    }

    private JButton sendButton(){
        send = new JButton("Send");
        send.setFont(new Font("TimesRoman", Font.BOLD, 30));
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                buffer.setText(buffer.getText()+"Stas : "+message.getText()+"\n");
                message.setText("");
            }
        });

        return send;
    }
}
