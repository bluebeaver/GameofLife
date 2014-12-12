import javax.swing.*;
import java.awt.*;



public class LifeMain {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Game Of Life");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 700));

        JPanel pan = new LifePanel();
        frame.add(pan);
        frame.pack();
        frame.setVisible(true);

    }

}


