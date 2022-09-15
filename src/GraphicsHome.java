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
        frame.getContentPane().setBackground(Color.GRAY);

        label = new JLabel("ChessGame");
        label.setFont(new Font("Serif", Font.PLAIN, 50));
        label.setBounds(275, 5, 300, 70);

        buttonStart = new JButton("Start");
        buttonHowToPlay = new JButton("How To Play");
        buttonSettings = new JButton("Settings");

        buttonStart.setBounds(287, 150, 225, 60);
        buttonHowToPlay.setBounds(287, 215, 225, 60);
        buttonSettings.setBounds(287, 280, 225, 60);

        frame.add(label);
        frame.add(buttonStart);
        frame.add(buttonHowToPlay);
        frame.add(buttonSettings);

        frame.setVisible(true);
    }
}
