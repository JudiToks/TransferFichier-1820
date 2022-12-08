package code;

import java.io.*;
import java.net.*;
import java.nio.file.Path;

import code.Code;
import graph.ClientFrame;

public class User
{
    public static ClientFrame clientFrame;

///constructor
    public User(){}
    public User(ClientFrame cf)
    {
        this.clientFrame = cf;
    }

    public static void send(String path , Code Code) throws Exception
    {
        String[] tab = {"Server1" , "Server2" , "Server3" , "Client"};
        Socket sock = new Socket(InetAddress.getLocalHost(), 1820); 
        ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
        out.writeInt(tab.length);
        for (int i = 0; i < tab.length; i++) 
        {
            out.writeUTF(tab[i]);
        }
        Code.asaOK(new FileInputStream(new File(path)) , out , true);
        sock.close();
    }

    public static void receved() throws Exception
    {
        Code Code = new Code();
        Socket socket = new ServerSocket(1820).accept();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        int n = in.readInt();
        String[] tab = new String[n];
        for (int i = 0; i < tab.length; i++) 
        {
            tab[i] = in.readUTF();
        }
        // String[] extension = clientFrame.getTextField().getText().split(".", 2);
        // if (extension[1].equalsIgnoreCase("png") || extension[1].equalsIgnoreCase("jpg") || extension[1].equalsIgnoreCase("jpeg")) 
        // {
            int isafile = 0;
            File file = new File("Sary/Receved");
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) 
            {
                if (files[i].isFile()) 
                {
                    isafile++;
                }
            }
            Code.asaOK(in , new FileOutputStream(new File("Sary/Receved/reseved"+(isafile+1)+".png"), true) , true);
        // }
        socket.close();

        for (String s : tab) 
        {
            System.out.println(s);
        }
    }
}