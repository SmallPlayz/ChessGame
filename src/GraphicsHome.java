import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GraphicsHome {

    int widthx;
    int heightx;

    JFrame frame;
    JLabel label;
    JLabel labelHowToPlay;
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

        labelHowToPlay = new JLabel("How To Play:");
        labelHowToPlay.setFont(new Font("Serif", Font.PLAIN, 50));
        labelHowToPlay.setBounds(40, 40, 300, 70);

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
        frame.add(labelHowToPlay);

        labelHowToPlay.setVisible(false);

        buttonHowToPlay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    labelHowToPlay.setVisible(true);
                buttonStart.setVisible(false);
                buttonHowToPlay.setVisible(false);
                buttonSettings.setVisible(false);
                }
            });

        frame.setVisible(true);
    }
}
