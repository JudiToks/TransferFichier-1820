package code;

import java.io.IOException;

import graph.ServerFrame;

public class Server extends User
{
///constructor
    public Server(){}
    
    public static void main(String[] args) throws Exception , IOException
    {
        Server server = new Server();
        new ServerFrame("Server");
        server.receved();
    }
}
