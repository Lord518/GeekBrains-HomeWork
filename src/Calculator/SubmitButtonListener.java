package Calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitButtonListener implements ActionListener {
    private JTextField inputField;
    public SubmitButtonListener(JTextField inputField){
        this.inputField= inputField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder(inputField.getText());
        inputField.setText("");
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        int submit =0;
        try {
            submit = (Integer) engine.eval( sb.toString() );
        } catch (ScriptException scriptException) {
            scriptException.printStackTrace();
            System.out.println(submit);
        }

        sb = new StringBuilder();
        sb.append(submit);
        inputField.setText(sb.toString());

    }


}