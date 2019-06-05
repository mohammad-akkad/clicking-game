/*
 Muhammed Akkad
 13060160209
 */
package ClickingGame;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Muhammed
 */
public class ServerListener extends Thread {

    private int portNumber;
    private int clientCount;
    private FrameBehavior myFrm;
    private ServerSocket serverSocket;
    private JButton beginButton;
    private ArrayList objectsMessage = new ArrayList<String>();
    private Client clt;
    private String shapeId;
    private String width;
    private String Length;
    int numberOfShapes;
    int[] shapeScores = new int[3];
    int clickedShapes = 0;

    /**
     *
     * @param port
     * @param mFrm
     */
    public ServerListener(String port, FrameBehavior mFrm) {
        portNumber = Integer.parseInt(port);
        serverSocket = null;
        clientCount = 1;
        Client g1 = new Client(null, mFrm);
        Info.clients = new ArrayList<Client>();
        for (int i = 0; i < 3; i++) {
            shapeScores[i] = new Random().nextInt(10 + 1 + 10) - 10;
        }
        Info.clients.add(g1);
        myFrm = mFrm;
    }

    /**
     *
     * @param width
     * @param Length
     */
    public void begin(String width, String Length) {
        String message = positionObjects(width, Length);
        for (Client clt : Info.clients) {
            clt.myOutputMessages.add(message);
        }

    }

    /**
     *
     * @param clt
     * @param id
     */
    public void click(Client clt, String id) {
        clickedShapes++;
        this.shapeId = id;
        this.clt = clt;
        String[] shape = this.objectsMessage.get((parseInt(id) - 1)).toString().split(" ");
        int shapeIndex = 0;
        switch (shape[0]) {
            case "circle":
                shapeIndex = 0;
                break;
            case "square":
                shapeIndex = 1;
                break;
            case "rectangle":
                shapeIndex = 2;
                break;

        }
        this.clt.updateScore(shapeScores[shapeIndex]);
        clt.myOutputMessages.add("update:" + clt.getScore());
        this.objectsMessage.remove((parseInt(id) - 1));

        if (clickedShapes >= 30) {
            endGame();
            return;
        }
        this.numberOfShapes = this.numberOfShapes - 1;
        String message = "";
        if (this.numberOfShapes == 0) {
            message = positionObjects(width, Length);
        } else {
            message = positionObjects();
        }
        for (Client client : Info.clients) {
            client.myOutputMessages.add(message);
        }

    }

    public void endGame() {
        int[] scores = new int[Info.clients.size() - 1];
        int i = 0;
        for (Client client : Info.clients) {
            if (!"".equals(client.getTakma())) {
                scores[i] = client.getScore();
                i++;
            }

        }
        int maxIndex = getIndexOfLargest(scores);
        String winnerName = Info.clients.get(maxIndex + 1).getTakma();
        int winnerScore = Info.clients.get(maxIndex + 1).getScore();
        for (Client client : Info.clients) {
            client.myOutputMessages.add("finish:" + winnerName + ":" + winnerScore);
        }
    }

    /**
     *
     * @param array
     * @return
     */
    public int getIndexOfLargest(int[] array) {
        if (array == null || array.length == 0) {
            return -1; // null or empty
        }
        int largest = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[largest]) {
                largest = i;
            }
        }
        return largest; // position of the first largest found
    }

    /**
     *
     * @param width
     * @param Length
     * @return
     */
    public String positionObjects(String width, String Length) {

        this.width = width;
        this.Length = Length;
        String[] objects = {"square", "rectangle", "circle"};
        String[] colors = {"red", "green", "black", "white", "yellow", "blue"};
        this.numberOfShapes = new Random().nextInt(10) + 3;
        String message = "";
        String object;
        for (int i = 1; i <= this.numberOfShapes; i++) {
            object = objects[new Random().nextInt(objects.length)] + " " + new Random().nextInt(parseInt(width) / 2) + " "
                    + new Random().nextInt(parseInt(Length) / 2) + " " + colors[new Random().nextInt(colors.length)] + ":";
            message = message + i + " " + object;
            this.objectsMessage.add(object);
        }
        return "Begin:" + width + ":" + Length + ":" + numberOfShapes + ":" + shapeScores[0] + ":" + shapeScores[1] + ":" + shapeScores[2] + ":" + message;
    }

    public String positionObjects() {

        String finalMessage = "";
        int i = 1;
        for (Object objectMessage : this.objectsMessage) {
            finalMessage = finalMessage + i + " " + objectMessage;
            i++;
        }
        return "Continue:" + width + ":" + Length + ":" + numberOfShapes + ":" + shapeScores[0] + ":" + shapeScores[1] + ":" + shapeScores[2] + ":" + finalMessage;

    }

    public void run() {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException ioEx) {
            System.exit(1);
        }

        do {
            try {
                Socket client = serverSocket.accept();
                Client newGamer = new Client(client, myFrm);
                Info.clients.add(newGamer);
                clientCount++;

                if (clientCount >= 2) {
                    myFrm.makeAction("Ready:", null);
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (clientCount <= 5);

    }
}
