/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataserver;

import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author mirsahib
 */
public class DataServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        ServerSocket server=null;
        try {
            server = new ServerSocket(3333);
            server.setReuseAddress(true);
            while(true){
                Socket client = server.accept();
                System.out.println("New client connected: "+client.getInetAddress().getHostAddress());
                ClientHandler clientSocket = new ClientHandler(client);
                //creating new thread
                new Thread(clientSocket).start();
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
