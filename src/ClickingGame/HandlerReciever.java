/*
 Muhammed Akkad
 13060160209
 */
package ClickingGame;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.JFrame;

/**
 *
 * @author Muhammed
 */
public class HandlerReciever extends Thread {

    private Socket client;
    private Scanner input;
    //  private PrintWriter output;
    private ArrayBlockingQueue<String> myMessages;
    private FrameBehavior myFrame;
    private Client me;

    /**
     *
     * @param socket
     * @param msg
     * @param frm
     * @param c
     */
    public HandlerReciever(Socket socket, ArrayBlockingQueue<String> msg,
            FrameBehavior frm, Client c) {
        //Set up reference to associated socket...
        client = socket;
        myMessages = msg;
        myFrame = frm;
        me = c;
        try {
            input = new Scanner(client.getInputStream());
        } catch (IOException ioEx) {
        }
    }

    public void run() {
        String received;
        do {
            received = input.nextLine();
            String[] protocolMsg = received.split(":");
            if (received != null && received != "") {
                myFrame.makeAction(received, me);
            }
            received = "";

        } while (!received.equals("QUIT"));

        try {
            if (client != null) {
                System.out.println("Closing down connection...");
                client.close();
            }
        } catch (IOException ioEx) {
            System.out.println("Unable to disconnect!");
        }
    }
}
