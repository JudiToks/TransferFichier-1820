package graph;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class ServerFrame extends JFrame
{
    JPanel panel;

    public ServerFrame(String nom) throws Exception
    {
        super(nom);

        panel = new JPanel();
        panel.setBounds(0 , 0 , 100 , 100);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(100, 100);
        setVisible(true);
    }
}
