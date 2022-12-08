package code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import graph.Transfert;

public class Code 
{
    Transfert transfert;

///constructor
    public Code(Transfert transfert)
    {
        this.transfert = transfert;
    }
    public Code(){}

///fonctions
    public void transfert(InputStream in , OutputStream out , boolean closeOnExit)
    {
        try 
        {
            if (transfert != null) 
            {
                transfert.setVisible(true);
            }
            byte[] buf = new byte[1024];
            int n = in.read(buf);
            while(n != -1)
            {
                out.write(buf , 0 , n);
                n = in.read(buf);
                if (transfert != null) 
                {
                    transfert.setPourcentage(100);
                    transfert.paintPourcentage(transfert.getGraphics());
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
