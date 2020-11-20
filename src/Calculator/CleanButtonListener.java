package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CleanButtonListener implements ActionListener {

    private JTextField inputField;
    public CleanButtonListener(JTextField inputField){
        this.inputField= inputField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        inputField.setText(" ");
    }
}
