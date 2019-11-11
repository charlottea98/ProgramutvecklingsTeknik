package Lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StenSaxPase {
    String hands[];
    Socket sock;
    BufferedReader in;
    PrintWriter out;
    String name;

    public StenSaxPase(String host, int port, String name){
        this.hands = new String[]{"STEN", "SAX", "PASE"};
        this.sock = getSocket(host, port);
        this.in = getInStream(this.sock);
        this.out = getOutputStream(this.sock);
        this.name=name;
        startGame();
    }


    public String compare(String computerhand, String playerHand){
        if(!computerhand.equals(playerHand)){
            if(playerHand.equals("STEN")){
                if(computerhand.equals("PASE")){
                    return "LOSS";
                }
                else{
                    return "WIN";
                }
            }

            if(playerHand.equals("SAX")){
                if(computerhand.equals("STEN")){
                    return "LOSS";
                }
                else{
                    return "WIN";
                }
            }

            if(playerHand.equals("PASE")) {
                if (computerhand.equals("SAX")) {
                    return "LOSS";
                } else {
                    return "WIN";
                }
            }
        }
        else{
            return "DRAW";
        }
        return null;
    }

    public String getComputer(BufferedReader in){
        try{
            return in.readLine();
        }
        catch(IOException e){
            System.err.println(e);
        }
        return null;
    }

    private Socket getSocket(String host, int port){
        try {
            Socket sock = new Socket(host, port);
            return sock;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private BufferedReader getInStream(Socket sock){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            return in;
        }
        catch(IOException e){
            System.err.print(e);
        }

        return null;
    }

    private PrintWriter getOutputStream(Socket sock){
        try{
            PrintWriter ut = new PrintWriter(sock.getOutputStream());
            return ut;
        }
        catch(IOException e){
            System.err.println(e);
        }
        return null;
    }

    private void startGame(){
        try {
            this.out.println(this.name);
            this.out.flush();
            //System.out.println(this.in.readLine());
            this.in.readLine();
        }
        catch(IOException e) {
            System.err.println(e);
        }
    }


    public static void main(String[] args){
        StenSaxPase model = new StenSaxPase("localhost", 4713, "Lotta och Mood");
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(model.sock.getInputStream()));
            PrintWriter ut = new PrintWriter(model.sock.getOutputStream());

            Scanner inputHand = new Scanner(System.in);
            String computerhand;
            while(true){
                String playerhand = model.hands[inputHand.nextInt()];
                ut.println(playerhand);
                ut.flush();
                computerhand = model.getComputer(in);
                System.out.println("P:" + playerhand + "  " + "CU: " + computerhand);
                System.out.println(model.compare(computerhand, playerhand));
            }
        }
        catch(IOException e){
            System.err.println(e);
        }
    }
}