//required import statements

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class Main extends JPanel {


    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    //required global variables
    private final BufferedImage image;
    private final Graphics g;
    private final JToggleButton dashButton; //Toggle button to open the dashboard, a parody of the start menu

    //Constructor required by BufferedImage
    public Main() {
        //set up Buffered Image and Graphics objects
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        //Icon for the dashboard button
        ImageIcon dashButtonIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("door.png")));

        //Configure a null layout in order for us to place buttons wherever we want
        this.setLayout(null);

        //Create and add dashboard button to the pane
        dashButton = new JToggleButton(dashButtonIcon);
        add(dashButton);


        //set up and start the Timer
        Timer timer = new Timer(10, new TimerListener());
        timer.start();

    }

    //main method with standard graphics code
    public static void main(String[] args) {
        JFrame frame = new JFrame("Smolldove Whiteboard 22");
        frame.setSize(WIDTH + 18, HEIGHT + 47);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Main());
        frame.setVisible(true);

    }

    //NOTE: The table is intended to be a parody of the taskbar in windows
    public void tableManager(Graphics g, int size, Color color) {
        //Draw the triangle as the base of the table
        int[] xPoints = {WIDTH, WIDTH - size, WIDTH};
        int[] yPoints = {HEIGHT, HEIGHT, HEIGHT - size};
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, 3);

        //configure placement of the dashButton
        dashButton.setBounds(WIDTH - size / 4 + getInsets().left, HEIGHT - size / 4 + getInsets().top, size / 4, size / 4);
        //If the button is selected, open the start menu (currently empty)
        if (dashButton.isSelected()) {
            g.setColor(Color.blue);
            g.fillRect(WIDTH - size, HEIGHT - size, size * 3 / 4, size * 3 / 4);
        }
    }

    //do not modify this
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    //TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Code to draw background Image
            Image image = null;
            try {
                image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("birb.png")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.drawImage(image, 0, 0, Color.darkGray, null); //Color can be changed here to change background color due to transparent png

            //Launch the table manager
            tableManager(g, 200, Color.cyan);

            repaint(); //leave this alone, it MUST  be the last thing in this method
        }

    }

}
