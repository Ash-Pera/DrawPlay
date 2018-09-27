/**
 * Contributions from Ash Pera
 * Contributions from Alex Whiteree
 */

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MyDrawing extends JPanel {
	private Cat cat;
	private Cat cat2;
	private Cat cat3;
	private Cat running_cat;
	public MyDrawing() 
	{
		// Add critters to the drawing
		cat = new Cat();
		cat2 = new Cat();
		cat3 = new Cat();
		running_cat = new Cat();
	}
	
	double running_cat_loc = 0;
	boolean running_cat_going_right = true;
	// paintComponent is called automatically when the frame needs
	// to display (e.g., when the program starts)
	public void paintComponent(Graphics g) {
		cat.draw(g, 50, 50);
		cat2.draw(g, 150, 150);
		cat3.draw(g, 250, 25);
		running_cat.draw(g, (int)running_cat_loc, 300);
		if(running_cat_going_right) {
			running_cat_loc += 0.10;
		} else {
			running_cat_loc -= 0.10;
		}
	
		
		if(running_cat_loc > 300) {
			running_cat_going_right = false;
		} else if (running_cat_loc < 0) {
			running_cat_going_right = true;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		// Create a JPanel (MyDrawing), we'll draw on this
		frame.setContentPane(new MyDrawing());
		// Program will end when the window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set the size (otherwise only title bar displays)
		frame.setSize(400, 400);
		
		// Frame will not display until you set visible true
		frame.setVisible(true);
		
		while(true) {
			frame.repaint();
		}
	}

}
