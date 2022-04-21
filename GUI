import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;	

@SuppressWarnings("unused")
public class GUI extends Solution {
	
	private static int totalStores = 0;
	private static int distance = 0;
	private static Location[] exitList = null;
	
	private static JFrame mainFrame = new JFrame();
	private static JPanel mainPanel = new JPanel();
	private static JPanel topPanel = newGridPanel(mainPanel, 1, 2);
	
	private static JPanel storePanel = newGridPanel(topPanel, 2, 1);
	private static JLabel totalLabel = newTotalLabel(storePanel);
	private static JTextField totalText = newTotalText(storePanel);
	
	private static JPanel distancePanel = newGridPanel(topPanel, 2, 1);
	private static JLabel distanceLabel = newDistanceLabel(distancePanel);
	private static JTextField distanceText = newDistanceText(distancePanel);
	
	private static JPanel displayPanel = newGridBagPanel(mainPanel);
	
	private static JButton updateButton = newUpdateButton(mainPanel);
	
	
	public static void main(String[] args) {
		
		topPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), " Exits and Distance "));
		displayPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), " Exit Information "));	
		
		mainPanel.setPreferredSize(new Dimension(800, 400));
		mainPanel.setLayout(new GridLayout(3, 1, 1, 1));
	
		mainFrame.setSize(1200, 800);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("HW10 - Graphical StarBuzz - Elijah Adams");
		mainFrame.setVisible(true);

		mainFrame.add(mainPanel, BorderLayout.NORTH);
		mainFrame.validate();
		
	}
	
	private static JButton newUpdateButton(JPanel parent) {
		
		final JButton button = new JButton();
		button.setText("Update Graphics");
		
		button.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        updateGraphics();
		    }
		});
		
		parent.add(button);
		return button; 
		
	}
	
	
	private static void updateGraphics () {
		
		final int topX = mainFrame.getWidth() / 6;
		final int topY = 200;
		final int lineLength = (2 * mainFrame.getWidth()) / 3;
		
		mainFrame.add(new DrawTest(topX, topY, exitList, best_taken, distance, mainFrame.getWidth(), lineLength));
		mainFrame.validate();

	}
	
	
	private static void updateDisplay () {
		
		// reset display
		displayPanel.removeAll();
		displayPanel.repaint();
		
		// don't add zero stores
		if (totalStores == 0)
			return;
		
		// calculate store and legend panel size
		final int borderWidth = 50;
		final int legendWidth = 90;
		final int width = (displayPanel.getWidth() - legendWidth - borderWidth) / totalStores;
		final int height = displayPanel.getHeight() - borderWidth;
		final Dimension storeSize = new Dimension(width, height);
		final Dimension legendSize = new Dimension(legendWidth, height);
		
		// colors
		final Color dark_gray = new Color(190, 190, 190);
		final Color light_gray = new Color(210, 210, 210);
		
		// add legend panel
		final JPanel legendPanel = Location.createLegend(legendSize);
		legendPanel.setBackground(dark_gray);
		displayPanel.add(legendPanel);
		
		exitList = new Location[totalStores];
		// create individual store panels
		for (int i = 1; i <= totalStores; i++) {
			final Location newStore = new Location();
			final JPanel storePanel = newStore.createStore(i, storeSize);
			exitList[i - 1] = newStore;
			
			// alternate store panel color
			if ((i & 1) == 0)
				storePanel.setBackground(dark_gray);
			else
				storePanel.setBackground(light_gray);
			
			displayPanel.add(storePanel);
			
		}
		displayPanel.repaint();
		
	}
	
	private static JPanel newGridBagPanel (JPanel parent) {
		
		final JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		parent.add(panel);
		return panel;
		
	}

	private static JLabel newTotalLabel (JPanel parent) {
		
		final JLabel label = new JLabel();
		label.setText("Total Exits: Invalid Input");
		parent.add(label);
		return label;
		
	}
	
	private static JTextField newTotalText (JPanel parent) {
		
		final JTextField text = new JTextField();
		
		text.addKeyListener(new KeyAdapter()
		{
		    public void keyReleased(KeyEvent e) 
		    {
				try {
					final String t = text.getText();
					totalStores = Integer.parseInt(t);
					
					if (totalStores <= 0) {
						totalLabel.setText("Total Exits: Invalid Input");
						totalStores = 0;
					} else
						totalLabel.setText("Total Exits: " + totalStores);
				}
				catch (Exception ex) {
					totalLabel.setText("Total Exits: Invalid Input");
					totalStores = 0;
				}
				updateDisplay();
		    }
		});
		
		parent.add(text);
		return text;
		
	}
	
	private static JPanel newGridPanel (JPanel parent, int rows, int columns) {
		
		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(rows, columns, 1, 1));
		parent.add(panel);
		return panel;
		
	}

	private static JLabel newDistanceLabel (JPanel parent) {
		
		final JLabel label = new JLabel();
		label.setText("Minimum Distance: Invalid Input");
		
		parent.add(label);
		return label;
		
	}
	
	private static JTextField newDistanceText (JPanel parent) {
		
		final JTextField text = new JTextField();
		
		text.addKeyListener(new KeyAdapter()
		{
		    public void keyReleased(KeyEvent e) 
		    {
				try {
					final String t = text.getText();
					distance = Integer.parseInt(t);
					
					if (distance <= 0) {
						distanceLabel.setText("Minimum Distance: Invalid Input");
						distance = 0;
					} else
						distanceLabel.setText("Minimum Distance: " + distance);
					
				}
				catch (Exception ex) {
					distanceLabel.setText("Minimum Distance: Invalid Input");
					distance = 0;
				}
				
				Solution.calculateSolution(exitList, distance, totalStores);
		    }
		});

		parent.add(text);
		return text;
		
	}

}
