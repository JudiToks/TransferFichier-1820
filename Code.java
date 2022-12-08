package code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JLabel;

import graph.JobDone;

public class Code 
{
    JobDone asa;

///constructor
    public Code(JobDone asa)
    {
        this.asa = asa;
    }
    public Code(){}

///fonctions
    public void asaOK(InputStream in , OutputStream out , boolean closeOnExit)
    {
        try 
        {
            if (asa != null) 
            {
                asa.setVisible(true);
            }
            byte[] buf = new byte[1024];
            int n = in.read(buf);
            while(n != -1)
            {
                out.write(buf , 0 , n);
                n = in.read(buf);
                if (asa != null) 
                {
                    asa.add(new JLabel("Done !!"));
                }
            }
            if (closeOnExit) 
            {
                in.close();
                out.close();
            }
        } 
        catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
