//required import statements
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;


public class Main extends JPanel implements ActionListener{

	//TODO: set the initial width and height of your image
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	//required global variables
	private final BufferedImage image;
	private final Graphics g;

	//Constructor required by BufferedImage
	public Main() {
		//set up Buffered Image and Graphics objects
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		/*TODO: Code to setup the objects you will animate goes here
		        All objects declared above should be initialized here
			    ex. cloud = new Cloud(100, 100, 250, 70, Color.WHITE);
			        cloud.setXSpeed(2);
		*/
		//button = new Button();
		//private Button button;
		//private int mouseButtonID;
		JToggleButton jButton = new JToggleButton("Hi I am a Button :)");
		add(jButton);
		jButton.setActionCommand("buttonPushy");
		jButton.addActionListener(this);

		//set up and start the Timer
		Timer timer = new Timer(10, new TimerListener());
		timer.start();
		addMouseListener(new Mouse());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button Has been Click-eth");
	}

	//TimerListener class that is called repeatedly by the timer
	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			/* TODO: Move the objects that need to be animated
			 * 		 Draw your ENTIRE scene
			 * 		 Don't forget to call repaint!
			 */

			Image image = null;
			try {
				image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("birb.png")));
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			g.drawImage(image, 0, 0, Color.darkGray, null);

			tableManager(g, 200, Color.cyan);

			repaint(); //leave this alone, it MUST  be the last thing in this method
		}

	}
	private static class Mouse implements MouseListener {
		public void mouseClicked(MouseEvent e) {

		}
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void mousePressed(MouseEvent e) {
			//mouseButtonID = e.getButton();
		}
		public void mouseReleased(MouseEvent e) {
			//mouseButtonID = 0;
		}
	}

	public void tableManager(Graphics g, int size, Color color) {
		//button.setDown(false);
		int[] xPoints = {WIDTH, WIDTH-size, WIDTH};
		int[] yPoints = {HEIGHT, HEIGHT, HEIGHT-size};
		g.setColor(color);
		g.fillPolygon(xPoints, yPoints, 3);
		//button.draw(g);
		Point p = getMousePosition();


		//if (//button.pointInButton((int)getMousePosition().getX(), (int)getMousePosition().getY()) && mouseButtonID == 1) {
		//button.setDown(true);
		//}


	}

	//do not modify this
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	//main method with standard graphics code
	public static void main(String[] args) {
		JFrame frame = new JFrame("B");
		frame.setSize(WIDTH + 18, HEIGHT + 47);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Main());
		frame.setVisible(true);
	}

}
