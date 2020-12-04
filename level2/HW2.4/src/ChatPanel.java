import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
//pull-request

public class ChatPanel {
    private JPanel panel;

    private JTextArea chat;
    public ChatPanel(JTextArea b) {
        panel = new JPanel();
        this.chat = b;
        initPanel();
    }
    public JPanel getPanel() {
        return panel;
    }

    private void initPanel() {
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.setLayout(new GridLayout());
        chat.setLineWrap(true);
        chat.setEditable(false);
        chat.setFont(new Font("TimesRoman", Font.BOLD, 20));
        JScrollPane scrollPane = new JScrollPane(chat);
        panel.add(scrollPane, BorderLayout.CENTER);


    }
}
