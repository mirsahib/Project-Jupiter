/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclient;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mirsahib
 */
public class DataClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        String host = "127.0.0.1";
        int port = 3333;
        try {
            Socket s = new Socket(host,port);
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            Scanner console = new Scanner(System.in);
            String line = null;
            while(!"exit".equalsIgnoreCase(line)){
                line = console.nextLine();
                out.println(line);
                out.flush();
                System.out.println("Server reply: "+in.readLine());
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

   

}
