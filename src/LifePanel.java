import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LifePanel  extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

    private LifeGrid lifeGrid;
    private LifeButton clearButton, stopButton, startButton;
    private LifePalette palette;
    private Color color;
    public Timer timer;

    public LifePanel() {
        setSize(600,600);
        lifeGrid = new LifeGrid(getHeight());

        startButton = new LifeButton(this, "Start", 50);
        stopButton = new LifeButton(this, "Stop", 150);
        clearButton = new LifeButton(this, "Clear", 250);

        palette = new LifePalette();

        timer=new Timer(250,this);

        addMouseListener(this);
        addMouseMotionListener(this);

    }

    public void actionPerformed(ActionEvent actionEvent){
        lifeGrid.nextLife();
        repaint();
    }


    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.clearRect(0,0, getWidth(), getHeight());
        g2. setColor(new Color(175, 255, 233));
        g2.fillRect(0,0,700,700);

        lifeGrid.paint(g);
        clearButton.paint(g);
        stopButton.paint(g);
        startButton.paint(g);
        palette.paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        if(startButton.isMe(x, y))
            timer.start();

        if (stopButton.isMe(x, y))
            timer.stop();

        if (clearButton.isMe(x, y))
            lifeGrid.clear();

        if(palette.isMe(x, y))
            lifeGrid.color = palette.getColor(x, y);

        repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        lifeGrid.fillCell(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        lifeGrid.changeColor(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
