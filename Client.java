package code;

import java.io.IOException;

import graph.ClientFrame;

public class Client extends User
{

///constructor
    public Client(){}

    public static void main(String[] args) throws Exception , IOException
    {
        Client client = new Client();
        new ClientFrame("Client" , client);
    }
}