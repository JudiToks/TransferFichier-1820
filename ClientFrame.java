package graph;

import java.awt.Font;

import javax.swing.*;

import code.Client;
import code.User;
import listener.*;
import graph.Transfert;

public class ClientFrame extends JFrame
{
    JLabel titre;
    JPanel panel;
    JLabel fileLabel;
    JButton search;
    JTextField textField;
    JLabel clientLabel;
    JComboBox comboBox;
    JButton sendButton;
    Transfert transfert;
    User user = new User(this);

///getters & setters
    public JTextField getTextField() {
        return textField;
    }
    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

///constructor
    public ClientFrame(String nom , Client client) throws Exception
    {
        super(nom);

        ///initialisation
        titre = new JLabel("Transfert de fichiers");
        panel = new JPanel();
        fileLabel = new JLabel("Fichier à envoyer :");
        search = new JButton("Choose");
        textField = new JTextField();
        clientLabel = new JLabel("Client correspondant :");
        comboBox = new JComboBox<>(new String[]{"Client1" , "Client2" , "Client3" , "Client4" , "Client5"});
        sendButton = new JButton("Send");
        transfert = new Transfert(panel);

        ///setPosition
        titre.setBounds(50, 10, 300, 50);
        titre.setFont(new Font("Arial", Font.BOLD, 30));

        panel.setBounds(10 , 70 , 380 , 200);
        panel.setLayout(null);
    
        fileLabel.setBounds(100 , 10 , 200 , 30);
        fileLabel.setFont(new Font("Arial", 0, 20));

        textField.setBounds(20 , 50 , 200 , 30);

        search.setBounds(240 , 50 , 100 , 30);
        search.addActionListener(new Search(textField));

        clientLabel.setBounds(100 , 100 , 250 , 30);
        clientLabel.setFont(new Font("Arial", 0, 20));

        comboBox.setBounds(20 , 150 , 200 , 30);

        sendButton.setBounds(240 , 150 , 100 , 30);
        sendButton.addActionListener(new Send(client , textField , transfert));

        ///add
        add(titre);
        panel.add(fileLabel);
        panel.add(textField);
        panel.add(search);
        panel.add(clientLabel);
        panel.add(comboBox);
        panel.add(sendButton);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400, 320);
        setVisible(true);
    }
}