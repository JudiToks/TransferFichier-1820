package listener;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import javax.swing.*;
import java.awt.event.*;

public class Search implements ActionListener
{
    JTextField textField;

///getters & setters
    public JTextField getTextField() {
        return textField;
    }
    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    ///constructor
    public Search(JTextField textField)
    {
        this.setTextField(textField);
    }

    public void actionPerformed(ActionEvent e)
    {
        JFileChooser test = new JFileChooser(new File(getTextField().getText()));
        File choix = new File(getTextField().getText());
        
        if (test.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
        {
            choix = test.getSelectedFile();
        }
        System.out.println(choix.getAbsolutePath());
        getTextField().setText(choix.getAbsolutePath());
    }
}
