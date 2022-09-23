import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable {

    private static Socket clientSocket = null;
    public static PrintStream os = null;
    private static DataInputStream is = null;
    private static BufferedReader inputLine = null;
    private static boolean closed = false;
    private static String username="";

    public static void main(String []args) {

        int portNumber = 12345; //port
        String host = "localhost";

        System.out.println("Now using host = " + host + ", portNumber = " + portNumber);
        Scanner input=new Scanner (System.in);
        String message="";
        String full="";
        Boolean exit=false;
        System.out.print("Input your username: ");
        username=input.nextLine();

        try {
            clientSocket = new Socket(host, portNumber);
            inputLine = new BufferedReader(new InputStreamReader(System.in));
            os = new PrintStream(clientSocket.getOutputStream());
            is = new DataInputStream(clientSocket.getInputStream());
            os.println(username);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (clientSocket != null && os != null && is != null) {
            try {
                new Thread(new Client()).start();
                while (!closed) {
                    os.println(inputLine.readLine().trim());
                }
                os.close();
                is.close();
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }

    }
    public void run() {
        String responseLine;
        try {
            while ((responseLine = is.readLine()) != null) {
                if(!responseLine.contains("[" +username + "]"))
                    System.out.println(responseLine);
            }
            closed = true;
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }
}