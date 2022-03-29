//required import statements
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Year;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicListUI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


@SuppressWarnings("serial")
public class Main extends JPanel {

	//TODO: set the initial width and height of your image
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	//required global variables
	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	private Button button;
	private boolean leftMouseClicked;
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
		button = new Button();
		

		//set up and start the Timer
		timer = new Timer(10, new TimerListener());
		timer.start();
		addMouseListener(new Mouse());
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
				image = ImageIO.read(this.getClass().getResource("birb.png"));
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			g.drawImage(image, 0, 0, Color.darkGray, null);

			tableManager(g, 200, Color.cyan);

			repaint(); //leave this alone, it MUST  be the last thing in this method
		}
		
	}
	private class Mouse implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getButton());
		}
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
	}

	public void tableManager(Graphics g, int size, Color color) {
		int[] xPoints = {WIDTH, WIDTH-size, WIDTH};
		int[] yPoints = {HEIGHT, HEIGHT, HEIGHT-size};
		g.setColor(color);
		g.fillPolygon(xPoints, yPoints, 3);
		button.draw(g);
		button.pointInButton((int)Objects.requireNonNull(getMousePosition()).getX(), (int)Objects.requireNonNull(getMousePosition()).getY());

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
