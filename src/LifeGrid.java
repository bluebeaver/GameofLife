import java.awt.*;

public class LifeGrid {


    private int[][] grid;
    private int[][] gridCopy;

    public Color color = Color.BLACK;
    private int cellLength;
    
    public int length = 40;
    
    public LifeGrid(int height) {
        cellLength = height / length;
        grid = new int[length][length];
    }

    public void changeColor(int x, int y) {
        int r = y/cellLength;
        int c = x/cellLength;

        if(r < length && c < length) {
            if (grid[r][c] == 1)
                grid[r][c] = 0;
            else
                grid[r][c] = 1;
        }
    }

    public void fillCell(int x, int y) {
        int r = y/cellLength;
        int c = x/cellLength;

        if(r < length && c < length) {
            if (grid[r][c] == 0)
                grid[r][c] = 1;
        }
    }

    public void clear() {
        for( int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length; c++)
                grid[r][c] = 0;
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(255, 250, 187));
        g2.fillRect(0,0,600,600);

        for( int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {

                if(grid[r][c] == 1) {
                    g2.setColor(color);
                    g2.fillRect(c * cellLength, r * cellLength, cellLength, cellLength);
                }

                g2.setColor(Color.BLACK);
                g2.drawRect(c * cellLength, r * cellLength, cellLength, cellLength);
            }
        }
    }

    public void nextLife() {
        gridCopy = new int[length][length];
        for (int i=0; i< grid.length; i++)
            for (int j = 0; j < grid[i].length ; j++)
                gridCopy[i][j] = grid[i][j];

        for (int i=0; i< grid.length; i++)
            for (int j = 0; j < grid[i].length ; j++)
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
    }
    
    private int numNeighbors(int r, int c){
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
}
