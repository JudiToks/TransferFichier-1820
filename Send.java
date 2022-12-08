package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import code.Client;
import code.Code;
import code.User;
import graph.JobDone;

public class Send implements ActionListener
{
    Client client;
    JTextField textField;
    JobDone asa;
    
    public Send(Client client , JTextField field , JobDone asa)
    {
        this.client = client;
        this.textField = field;
        this.asa = asa;
    }

    public void actionPerformed(ActionEvent e)
    {
        try 
        {
            client.send(textField.getText() , new Code(asa));
        } 
        catch (Exception er) 
        {
            er.printStackTrace();
        }
        
    }

}
