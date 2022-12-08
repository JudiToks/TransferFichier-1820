package graph;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class JobDone extends JPanel
{
///contstructor 
    public JobDone(JPanel panel)
    {
        setBounds(140, 150, 100, 30);
        setVisible(false);
        panel.add(this);
    }
}
