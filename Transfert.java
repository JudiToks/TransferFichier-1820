package graph;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Transfert extends JPanel
{
    double pourcentage = 0;

///contstructor 
    public Transfert(JPanel panel)
    {
        setBounds(200 , 300 , 500 , 30);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setVisible(false);
        panel.add(this);
    }

///fonction
    public void setPourcentage(double pourcentage) 
    {
        this.pourcentage = pourcentage;
    }
    public void paintPourcentage(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, ((int)pourcentage*getWidth())/100 , getHeight());
    }
}
