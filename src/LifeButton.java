import java.awt.*;

public class LifeButton {

    private LifePanel panel;
    private String caption;

    private int x;
    private int y;
    private int width = 80;
    private int height = 40;

    public LifeButton(LifePanel lifePanel, String ccaption, int xx) {
        panel = lifePanel;
        caption = ccaption;
        x = xx;
        y = 620;
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;

        g2. setColor(Color.BLACK);
        g2.fillRect(x, y, width, height);
        g2.setColor(Color.WHITE);
        g2.drawString(caption, x + 20, 640);
    }

    public boolean isMe(int xx, int yy) {
        return ((xx >= x) && (xx <= x + width) && (yy >= 620) && (yy <=660));
    }

}
