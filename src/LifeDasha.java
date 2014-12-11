import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class LifeDasha extends JPanel implements ActionListener, MouseListener, MouseMotionListener{

    private int[][] grid;
    private int[][] gridCopy;
    private int s;
    private Timer timer;
    private Color color;



    public LifeDasha(){
        grid = new int[40][40];
        setSize(600,600);
        s = getHeight()/grid.length;


        timer=new Timer(250,this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.clearRect(0,0,getWidth(),getHeight());
        g2. setColor(new Color(175, 255, 233));
        g2.fillRect(0,0,700,700);
        g2.setColor(new Color(255, 250, 187));
        g2.fillRect(0,0,600,600);



        for( int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {

                if(grid[r][c] == 1) {
                    g2.setColor(color);
                    g2.fillRect(c * s, r * s, s, s);



                }
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
                g2.fillRect(660,130,20,20);

                g2. setColor(Color.BLACK);
                g2.fillRect(50, 620, 80, 40);
                g2.fillRect(150,620,80,40);
                g2.fillRect(250,620,80,40);
                g2.setColor(Color.WHITE);
                g2.drawString("Stop", 70, 640);
                g2.drawString("Start",170,640);
                g2.drawString("Clear",270,640);
                g2.setColor(Color.BLACK);
                g2.drawRect(c * s, r * s, s, s);


            }
        }
    }
    public int numNeighbors(int r, int c){
        int count = 0;

        try {
            if (gridCopy[r - 1][c-1] == 1)
                count++;

        }
        catch(Exception e){ }
        try {
            if (gridCopy[r - 1][c+1] == 1)
                count++;

        }
        catch(Exception e){ }
        try {
            if (gridCopy[r - 1][c] == 1)
                count++;

        }
        catch(Exception e){ }
        try {
            if (gridCopy[r][c+1] == 1)
                count++;
        }
        catch(Exception e){ }
        try {
            if (gridCopy[r][c-1] == 1)
                count++;

        }
        catch(Exception e){ }
        try {
            if (gridCopy[r + 1][c+1] == 1)
                count++;

        }
        catch(Exception e){ }
        try {
            if (gridCopy[r + 1][c-1] == 1)
                count++;

        }
        catch(Exception e){ }try {
            if (gridCopy[r + 1][c] == 1)
                count++;

        }



        catch(Exception e){ }




        return count;

    }

    public void actionPerformed(ActionEvent actionEvent){
        gridCopy = new int[40][40];
        for (int i=0; i<grid.length; i++)
            for (int j = 0; j <grid[i].length ; j++)
                gridCopy[i][j] = grid[i][j];







                for (int i=0; i<grid.length; i++)
            for (int j = 0; j <grid[i].length ; j++)
                if( grid[i][j] == 1 ) {
                    if (numNeighbors(i, j) < 2){
                        grid[i][j] = 0;

                    }
                    else if (numNeighbors(i, j) > 3) {
                        grid[i][j] = 0;

                    }

                    }   else if (numNeighbors(i,j) == 3) {
                    grid[i][j] = 1;

                }

            repaint();

    }




    public static void main(String[] args) {

        JFrame frame = new JFrame("Game Of Life");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 700));

        JPanel pan = new LifeDasha();
        frame.add(pan);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        int r = y/s;
        int c = x/s;

        if ((x>=150) && (x<= 130) && (y>= 620) && (y<=660))
            timer=new Timer(250,this);
            timer.start();
        if ((x>=50) && (x<= 130) && (y>= 620) && (y<=660))
            timer.stop();
        if ((x>=250) && (x<= 130) && (y>= 620) && (y<=660)) {
            for (int i = 0; 1 <= 40; i++)
                grid[i][i] = 0;
        }




        if((x>=620) && (x<=640) && (y>=10) && (y<=30))
            color=new Color(239, 33, 4);
        if((x>=660) && (x<=680) && (y>=10) && (y<=30))
            color=new Color(254, 154, 6);
        if((x>=620) && (x<=640) && (y>=50) && (y<=70))
            color=new Color(255, 255, 9);
        if((x>=660) && (x<=680) && (y>=50) && (y<=70))
            color=new Color(22, 219, 0);
        if((x>=620) && (x<=640) && (y>=90) && (y<=110))
            color=new Color(13, 185, 190);
        if((x>=660) && (x<=680) && (y>=90) && (y<=110))
            color=new Color(7, 31, 190);
        if((x>=620) && (x<=640) && (y>=130) && (y<=150))
            color=new Color(190, 12, 188);
        if((x>=660) && (x<=680) && (y>=130) && (y<=150))
            color= new Color(0,0,0);





    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        int r = y/s;
        int c = x/s;

        if(grid[r][c] == 1){
            grid[r][c] = 0;

        }
        else {
            grid[r][c] = 1;

        }

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

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        int r = y/s;
        int c = x/s;


        grid[r][c] = 1;



        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}


