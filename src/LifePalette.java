import java.awt.*;

public class LifePalette {

    public boolean isMe(int x, int y) {
        return (x >= 620 && x <= 680 && y >= 10 && y <= 150);
    }

    public Color getColor(int x, int y) {
        if((x>=620) && (x<=640) && (y>=10) && (y<=30))
            return new Color(239, 33, 4);
        if((x>=660) && (x<=680) && (y>=10) && (y<=30))
            return new Color(254, 154, 6);
        if((x>=620) && (x<=640) && (y>=50) && (y<=70))
            return new Color(255, 255, 9);
        if((x>=660) && (x<=680) && (y>=50) && (y<=70))
            return new Color(22, 219, 0);
        if((x>=620) && (x<=640) && (y>=90) && (y<=110))
            return new Color(13, 185, 190);
        if((x>=660) && (x<=680) && (y>=90) && (y<=110))
            return new Color(7, 31, 190);
        if((x>=620) && (x<=640) && (y>=130) && (y<=150))
            return new Color(190, 12, 188);
        if((x>=660) && (x<=680) && (y>=130) && (y<=150))
            return new Color(0,0,0);

        return Color.BLACK;
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(239, 33, 4));
        g2.fillRect(620,10,20,20);

        g2.setColor(new Color(254, 154, 6));
        g2.fillRect(660,10,20,20);

        g2.setColor(new Color(255, 255, 9));
        g2.fillRect(620,50,20,20);

        g2.setColor(new Color(22, 219, 0));
        g2.fillRect(660,50,20,20);

        g2.setColor(new Color(13, 185, 190));
        g2.fillRect(620,90,20,20);

        g2.setColor(new Color(7, 31, 190));
        g2.fillRect(660,90,20,20);

        g2.setColor(new Color(190, 12, 188));
        g2.fillRect(620,130,20,20);

        g2.setColor(new Color(0, 0, 0));
        g2.fillRect(660, 130, 20, 20);
    }

}
