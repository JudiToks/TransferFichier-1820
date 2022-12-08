package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import code.Client;
import code.Code;
import graph.Transfert;

public class Send implements ActionListener
{
    Client client;
    JTextField textField;
    Transfert transfert;
    
    public Send(Client client , JTextField field , Transfert transfert)
    {
        this.client = client;
        this.textField = field;
        this.transfert = transfert;
    }

    public void actionPerformed(ActionEvent e)
    {
        try 
        {
            client.envoyer(textField.getText() , new Code(transfert));
        } 
        catch (Exception er) 
        {
            er.printStackTrace();
        }
        
    }

}
