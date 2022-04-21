import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// change to Location when finished
public class Location {
	
	private JPanel storePanel = new JPanel();
	private JLabel storeLabel = new JLabel();
	private JTextField locationTextField = new JTextField();
	private JTextField profitabilityTextField = new JTextField();
	
	private int exit_number;
	private int profit;

	public Location () {
		exit_number = 0;
		profit = 0;
	}

	public void setExit (int e) {
		exit_number = e;
	}
	public void setProfit (int p) {
		profit = p;
	}

	public int exitNumber () {
		return exit_number;
	}

	public int profit () {
		return profit;
	}
	
	
	private void exitListener (JTextField text) {
		text.addKeyListener(new KeyAdapter()
		{
		    public void keyReleased(KeyEvent e) 
		    {
				try {
					final String t = text.getText();
					exit_number = Integer.parseInt(t);
					
					if (exit_number <= 0) {
						System.out.print("Invalid Exit\n");
						exit_number = 0;
					}
				}
				catch (Exception ex) {
					System.out.print("Invalid Exit\n");
					exit_number = 0;
				}
		    }
		});
	}
	
	private void profitabilityListener (JTextField text) {
		text.addKeyListener(new KeyAdapter()
		{
		    public void keyReleased(KeyEvent e) 
		    {
				try {
					final String t = text.getText();
					profit = Integer.parseInt(t);
					
					if (profit <= 0) {
						System.out.print("Invalid Profit\n");
						profit = 0;
					}
				}
				catch (Exception ex) {
					System.out.print("Invalid Profit\n");
					profit = 0;
				}
		    }
		});
	}
	
	public void setStoreBackground (Color c) {
		storePanel.setBackground(c);
		storePanel.getParent().repaint();
	}
	
	public JPanel createStore (int store, Dimension size) {
		
		exitListener(locationTextField);
		profitabilityListener(profitabilityTextField);
		
		storePanel.setLayout(new GridLayout(3, 1, 1, 1));
		storePanel.setBackground(Color.RED);
		
		storeLabel.setText(Integer.toString(store));
		storeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		storeLabel.setVerticalAlignment(SwingConstants.CENTER);
		
		storePanel.setPreferredSize(size);
		storePanel.setSize(size);
		
		storePanel.add(storeLabel);
		storePanel.add(locationTextField);
		storePanel.add(profitabilityTextField);
		
		return storePanel;
	}
	
	public static JPanel createLegend (Dimension size) {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 1, 1));
		panel.setPreferredSize(size);
		panel.setSize(size);
		
		String[] titles = {"Exit: ",
						   "Location: ",
						   "Profitability: "};
		
		for (String name : titles) {
			JLabel label = new JLabel();
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setText(name);
			panel.add(label);
		}

		return panel;
	}

}
