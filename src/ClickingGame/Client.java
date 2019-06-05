/*
 Muhammed Akkad
 13060160209
 */
package ClickingGame;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Muhammed
 */
public class Client {

    public String TakmaAd = "";
    private long timeDifference = 0;
    private int score = 0;
    private Socket client;
    private FrameBehavior myFrame;
    public ArrayBlockingQueue<String> myInputMessages;
    public ArrayBlockingQueue<String> myOutputMessages;
    private HandlerReciever handleInput;
    private HandlerSender handleOutput;

    /**
     *
     * @param socket
     * @param frm
     */
    public Client(Socket socket, FrameBehavior frm) {
        client = socket;
        myFrame = frm;
        myInputMessages = new ArrayBlockingQueue(100);
        myOutputMessages = new ArrayBlockingQueue(100);
        if (client != null) {
            handleInput = new HandlerReciever(socket, myInputMessages, frm, this);
            handleOutput = new HandlerSender(socket, myOutputMessages);
            handleInput.start();
            handleOutput.start();
        }
    }

    public void setTakma(String TakmaAd) {
        this.TakmaAd = TakmaAd;
    }

    public String getTakma() {
        return this.TakmaAd;
    }

    public void setTimeDifference(long timeDifference) {
        this.timeDifference = System.currentTimeMillis() - timeDifference;
    }

    public long getTimeDifference() {
        return this.timeDifference;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void updateScore(int score) {
        this.score = this.score + score;
    }

    public int getScore() {
        return this.score;
    }
}
