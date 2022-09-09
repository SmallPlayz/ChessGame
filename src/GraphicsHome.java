import javax.swing.*;
import java.awt.*;

public class GraphicsHome {

    int widthx;
    int heightx;

    JFrame frame;
    JLabel label;
    JButton buttonStart;
    JButton buttonHowToPlay;
    JButton buttonSettings;

    GraphicsHome(int height, int width) {
        heightx = height;
        widthx = width;

        frame = new JFrame("Homepage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(widthx,heightx);
        frame.setResizable(true);
        frame.setLayout(null);

        label = new JLabel("ChessGame");
        label.setFont(new Font("Serif", Font.PLAIN, 50));
        label.setBounds(275, 20, 300, 70);

        buttonStart = new JButton("Start");
        buttonHowToPlay = new JButton("How To Play");
        buttonSettings = new JButton("Settings");

        buttonStart.setBounds(205, 27, 155, 43);




        frame.add(label);
        frame.add(buttonStart);
        frame.add(buttonHowToPlay);
        frame.add(buttonSettings);

        frame.setVisible(true);
    }
}
