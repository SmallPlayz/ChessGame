import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicsHome {

    int widthx;
    int heightx;

    JFrame frame;
    JLabel label;
    JLabel labelHowToPlay;
    JLabel labelSettings;
    JLabel labelHowToPlayInfo;
    JButton buttonStart;
    JButton buttonHowToPlay;
    JButton buttonSettings;
    JButton buttonBack;

    JSlider sliderVolume;

    static JLabel labelVolume;
    static boolean goback = true; // NOT USED CURRENTLY

    GraphicsHome(int height, int width) {
        heightx = height;
        widthx = width;

        Image icon = Toolkit.getDefaultToolkit().getImage("src/chessicon.png");

        frame = new JFrame("ChessGame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(widthx,heightx);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setIconImage(icon);

        label = new JLabel("ChessGame");
        label.setFont(new Font("Serif", Font.PLAIN, 50));
        label.setBounds(285, 5, 300, 70);

        labelHowToPlay = new JLabel("How To Play");
        labelHowToPlay.setFont(new Font("Serif", Font.PLAIN, 50));
        labelHowToPlay.setBounds(265, 5, 300, 70);

        labelHowToPlayInfo = new JLabel("bro its just chess lol");
        labelHowToPlayInfo.setFont(new Font("Serif", Font.PLAIN, 50));
        labelHowToPlayInfo.setBounds(230, 75, 500, 50);

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

        sliderVolume = new JSlider(JSlider.HORIZONTAL, 0, 100, 75);
        sliderVolume.setMinorTickSpacing(5);
        sliderVolume.setMajorTickSpacing(20);
        sliderVolume.setPaintLabels(true);
        sliderVolume.setLabelTable(sliderVolume.createStandardLabels(10));
        sliderVolume.setBounds(250, 100, 225, 100);
        sliderVolume.setBackground(Color.GRAY);

        labelVolume = new JLabel();
        labelVolume.setText("Volume: " + sliderVolume.getValue());
        labelVolume.setBounds(300, 200, 150, 45);
        frame.add(labelVolume);

        Thread threadVolume = new Thread(() -> {
            while(true) {
                labelVolume.setText("Volume: " + sliderVolume.getValue());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadVolume.start();

        frame.add(label);
        frame.add(buttonStart);
        frame.add(buttonHowToPlay);
        frame.add(buttonSettings);
        frame.add(labelHowToPlay);
        frame.add(labelHowToPlayInfo);
        frame.add(labelSettings);
        frame.add(buttonBack);
        frame.getContentPane().add(sliderVolume);

        labelHowToPlay.setVisible(false);
        labelSettings.setVisible(false);
        buttonBack.setVisible(false);
        labelVolume.setVisible(false);
        sliderVolume.setVisible(false);
        labelHowToPlayInfo.setVisible(false);

        buttonStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                GraphicsChess graphicsChess = new GraphicsChess(450, 500);
            }
        });
        buttonHowToPlay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelHowToPlay.setVisible(true);
                buttonStart.setVisible(false);
                buttonHowToPlay.setVisible(false);
                buttonSettings.setVisible(false);
                label.setVisible(false);
                labelSettings.setVisible(false);
                buttonBack.setVisible(true);
                labelHowToPlayInfo.setVisible(true);
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
                labelVolume.setVisible(true);
                sliderVolume.setVisible(true);
                goback = false;
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
                labelVolume.setVisible(false);
                sliderVolume.setVisible(false);
                labelHowToPlayInfo.setVisible(false);
                goback = true;
            }
        });
        frame.setVisible(true);
    }
}
