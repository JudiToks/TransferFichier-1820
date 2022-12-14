package listener;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import javax.swing.*;

import code.User;

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
        JFileChooser fileChooser = new JFileChooser(new File(getTextField().getText()));
        File file = new File(getTextField().getText());
        
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
        {
            file = fileChooser.getSelectedFile();
        }
        System.out.println(file.getAbsolutePath());
        getTextField().setText(file.getAbsolutePath());
    }
}
