package server;

import javax.swing.*;

public class ServerGraphics {

    JFrame frame;
    JTextField textField;

    private static int width = 0, height = 0;
    ServerGraphics(int FrameWidth, int FrameHeight){
        width = FrameWidth;
        height = FrameHeight;
        frame = new JFrame("Server");
        frame.setLayout(null);
        frame.setSize(width, height);
    }
}
