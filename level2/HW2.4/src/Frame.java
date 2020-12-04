import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame ()
    {
        setFont(new Font("TimesRoman", Font.BOLD, 30));
        setTitle("Chat");
        setBounds(new Rectangle(50, 50, 700, 900));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextArea buffer = new JTextArea();
        setLayout(new BorderLayout());
        JPanel topPanel = new ApplicationMenuPanel().getPanel();
        JPanel bottomPanel = new MessagePanel(buffer).getPanel();
        JPanel centerPanel = new ChatPanel(buffer).getPanel();
        add(topPanel,BorderLayout.PAGE_START);
        add(centerPanel,BorderLayout.CENTER);
        add(bottomPanel,BorderLayout.SOUTH);


        setVisible(true);

    }

}
