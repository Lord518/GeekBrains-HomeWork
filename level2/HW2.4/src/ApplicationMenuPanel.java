import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
//pull-request
public class ApplicationMenuPanel {
    private JPanel jPanel;

    public ApplicationMenuPanel() {
        this.jPanel = new JPanel();
        init();
    }

    public JPanel getPanel() {
        return jPanel;
    }

    private void init() {
        jPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));

        jPanel.setLayout(new GridLayout(1, 3));

        jPanel.add(initBarMenu());


    }

    private JMenuBar initBarMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("TimesRoman", Font.BOLD, 30));
        JMenu editMenu = new JMenu("Application menu");
        editMenu.setFont(new Font("TimesRoman", Font.BOLD, 15));
        menuBar.add(editMenu);
        JMenuItem settings = new JMenuItem("Settings");
        editMenu.add(settings);
        JMenuItem aboutTheProgram = new JMenuItem("About the program");
        editMenu.add(aboutTheProgram);
        JMenuItem exit = new JMenuItem("Exit");
        editMenu.add(exit);
        exit.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                System.exit(1);

            }


        });


        return menuBar;
    }


}
