package code;

import java.io.*;
import java.net.*;

import code.Code;
import graph.ClientFrame;

public class User
{
    static ClientFrame clientFrame;

///constructor
    public User(){}
    public User(ClientFrame cf)
    {
        this.clientFrame = cf;
    }

    public static void envoyer(String path , Code Code) throws Exception
    {
        String[] tab = {"Server1" , "Server2" , "Server3" , "Client"};
        Socket sock = new Socket(InetAddress.getLocalHost(), 1820); 
        ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
        out.writeInt(tab.length);
        for (int i = 0; i < tab.length; i++) 
        {
            out.writeUTF(tab[i]);
        }
        Code.transfert(new FileInputStream(new File(path)) , out , true);
        sock.close();
    }

    public static void recevoir() throws Exception
    {
        Code Code = new Code();
        Socket sock = new ServerSocket(1820).accept();
        ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
        int n = in.readInt();
        String[] tab = new String[n];
        for (int i = 0; i < tab.length; i++) 
        {
            tab[i] = in.readUTF();
        }
        // String[] extension = clientFrame.getTextField().getText().split(".", 2);
        // if (extension[1].equalsIgnoreCase("png") || extension[1].equalsIgnoreCase("jpg") || extension[1].equalsIgnoreCase("jpeg")) 
        // {
            Code.transfert(in , new FileOutputStream(new File("Sary/Recu/recu.png")) , true);
        // }
        sock.close();

        for (String s : tab) 
        {
            System.out.println(s);
        }
    }
}