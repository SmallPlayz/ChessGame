import javax.swing.*;
import java.awt.*;

public class GraphicsChess {

        JFrame frameChess;

    GraphicsChess(int heightx, int widthx) {
        frameChess = new JFrame("ChessGame");
        frameChess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChess.setSize(widthx,heightx);
        frameChess.setResizable(true);
        frameChess.setLayout(null);
        frameChess.getContentPane().setBackground(Color.GRAY);

        Image icon = Toolkit.getDefaultToolkit().getImage("src/chessicon.png");
        frameChess.setIconImage(icon);
        frameChess.setVisible(true);
    }
}
