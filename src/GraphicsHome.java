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
    JLabel labelSettings;
    JButton buttonStart;
    JButton buttonHowToPlay;
    JButton buttonSettings;
    JButton buttonBack;

    JSlider sliderVolume;

    GraphicsHome(int height, int width) {
        heightx = height;
        widthx = width;

        Image icon = Toolkit.getDefaultToolkit().getImage("src/chessicon.png");

        frame = new JFrame("ChessGame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(widthx,heightx);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setIconImage(icon);

        label = new JLabel("ChessGame");
        label.setFont(new Font("Serif", Font.PLAIN, 50));
        label.setBounds(285, 5, 300, 70);

        labelHowToPlay = new JLabel("How To Play");
        labelHowToPlay.setFont(new Font("Serif", Font.PLAIN, 50));
        labelHowToPlay.setBounds(265, 5, 300, 70);

        labelSettings = new JLabel("Settings");
        labelSettings.setFont(new Font("Serif", Font.PLAIN, 50));
        labelSettings.setBounds(300, 5, 300, 70);

        buttonStart = new JButton("Start");
        buttonHowToPlay = new JButton("How To Play");
        buttonSettings = new JButton("Settings");
        buttonBack = new JButton("Back");

        buttonStart.setBounds(287, 150, 225, 60);
        buttonHowToPlay.setBounds(287, 215, 225, 60);
        buttonSettings.setBounds(287, 280, 225, 60);
        buttonBack.setBounds(325, 355, 150, 45);

        sliderVolume = new JSlider(JSlider.HORIZONTAL, 0, 40, 10);
        sliderVolume.setMinorTickSpacing(5);
        sliderVolume.setMajorTickSpacing(20);
        sliderVolume.setPaintTicks(true);
        sliderVolume.setPaintLabels(true);
        sliderVolume.setLabelTable(sliderVolume.createStandardLabels(10));

        frame.add(label);
        frame.add(buttonStart);
        frame.add(buttonHowToPlay);
        frame.add(buttonSettings);
        frame.add(labelHowToPlay);
        frame.add(labelSettings);
        frame.add(buttonBack);
        frame.getContentPane().add(sliderVolume);

        labelHowToPlay.setVisible(false);
        labelSettings.setVisible(false);
        buttonBack.setVisible(false);

        buttonHowToPlay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelHowToPlay.setVisible(true);
                buttonStart.setVisible(false);
                buttonHowToPlay.setVisible(false);
                buttonSettings.setVisible(false);
                label.setVisible(false);
                labelSettings.setVisible(false);
                buttonBack.setVisible(true);
                }
        });
        buttonSettings.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelHowToPlay.setVisible(false);
                buttonStart.setVisible(false);
                buttonHowToPlay.setVisible(false);
                buttonSettings.setVisible(false);
                label.setVisible(false);
                labelSettings.setVisible(true);
                buttonBack.setVisible(true);
            }
        });
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelHowToPlay.setVisible(false);
                buttonStart.setVisible(true);
                buttonHowToPlay.setVisible(true);
                buttonSettings.setVisible(true);
                label.setVisible(true);
                labelSettings.setVisible(false);
                buttonBack.setVisible(false);
            }
        });
        frame.setVisible(true);
    }
}
