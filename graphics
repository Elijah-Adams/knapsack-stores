import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawTest extends JComponent
{
	
	private Location[] exitList;
	private Boolean[] bestList;
	private static int topX;
	private static int topY;
	private int lineWidth;
	private int minDistance;
	private int lineLength;
	
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	
	
	public DrawTest (int x, int y, Location[] e, Boolean[] b, int d, int w, int l) {
		topX = x;
		topY = y;
		exitList = e;
		bestList = b;
		lineWidth = w;
		minDistance = d;
		lineLength = l;
	}
	
	
	private void paintMinimumDistance (Graphics g, int exitX, int exitY) {
        Graphics2D g2 = (Graphics2D) g;
        int unit = getLineUnit();
        int dist = unit * minDistance;
        int radius = dist / 2;
        
        g2.setColor(Color.decode("#a86f74"));
        g2.drawOval(exitX - radius + 12, exitY - radius + 12, dist, dist);
	}
	
	
	private void paintExit (Graphics g, int myX, String exitNumber, String exitLocation, String exitProfit) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		int width = 24;
		int height = 24;
		int exitX = myX;
		int exitY = topY - 12;

		paintMinimumDistance(g, exitX, exitY);
		
		Rectangle2D rect = new Rectangle2D.Double(exitX, exitY, width, height);
		g2.setColor(Color.decode("#aaf7a6"));
		g2.fillRect(exitX, exitY, width, height);
		g2.draw(rect);
		
		g2.setColor(Color.BLACK);
		g2.drawString(exitLocation, exitX + (8 / exitLocation.length()), exitY + 16);
		drawRotate(g2, exitX + 7, exitY + 26, 90, "Profit: $" + exitProfit);
		
		
		
	}
	
	public static void drawRotate(Graphics2D g2d, double x, double y, int angle, String text) 
	{    
	    g2d.translate((float)x,(float)y);
	    g2d.rotate(Math.toRadians(angle));
	    g2d.drawString(text,0,0);
	    g2d.rotate(-Math.toRadians(angle));
	    g2d.translate(-(float)x,-(float)y);
	}
	
	private void paintLine (Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		int height = 2;

		Rectangle2D rect = new Rectangle2D.Double(topX, topY, lineLength, height);
		g2.setColor(Color.BLACK);
		g2.fillRect(topX, topY, lineLength, height);
		g2.draw(rect);
		
	}

	
	private int getLineUnit () {
		int max = exitList[exitList.length - 1].exitNumber();
		int min = exitList[0].exitNumber();
		int unit = (lineLength - 24) / (max - min);
		return unit;
	}
	
	private int calculateLineX (int exit) {
		int max = exitList[exitList.length - 1].exitNumber();
		int min = exitList[0].exitNumber();
		int unit = getLineUnit();
		
		int exitX = exitList[exit].exitNumber();
		if (exitX == max) return (topX + lineLength - 24);
		int fixedExitX = exitX - min;
		int lineX = (fixedExitX * unit) + topX;
		
		return lineX;
	}
	
	public void paintComponent(Graphics g) {
		
		
		
		
		
		paintLine(g);
		
		int i = 0;
		for (Boolean bestExit : bestList) {
			
			if (bestExit) {

				String exit = Integer.toString(i + 1);
				String location = Integer.toString(exitList[i].exitNumber());
				String profit = Integer.toString(exitList[i].profit());
				paintExit(g, calculateLineX(i), exit, location, profit);
				
			}
			i++;
		}
		
		
	}

	public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
