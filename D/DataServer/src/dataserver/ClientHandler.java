/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author mirsahib
 */
public class ClientHandler implements Runnable {
    
    private final Socket clientSocket;
    
    public ClientHandler(Socket client){
        this.clientSocket = client;
    }

    @Override
    public void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line;
            while((line=in.readLine())!=null){
                System.out.println("Sent from client: "+line);
                out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            try {
                out.close();
                in.close();
                clientSocket.close();
            } catch (Exception e) {
            
            }
        }
    }
}
