import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Button {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color buttonColor;
    private Color textColor;
    private String text;
    private Font font;

    public Button() {
        x = 100;
        y = 100;
        width = 200;
        height = 100;
        buttonColor = Color.white;
        textColor = Color.black;
        text = "button";
        font = new Font("Calibri", Font.PLAIN, 75);
    }
    //Constructor for a button with no text
    public Button(int x, int y, int width, int height, Color buttonColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonColor = buttonColor;
        textColor = null;
        text = "";
        font = null;
    }

    public Button(int x, int y, int width, int height, Color buttonColor, Color textColor, String text, Font font) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonColor = buttonColor;
        this.textColor = textColor;
        this.text = text;
        this.font = font;
    }

    public void draw(Graphics g) {
        Rectangle rect = new Rectangle(x, y, width, height);
        drawCenteredBackgroundedString(g, text, rect, font, textColor, buttonColor);
    }
    public  boolean pointInButton(int x, int y) {
        return x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.width;
    }
    /**
     * Draw a String centered in the middle of a Rectangle with a background.
     *
     * @param goon      The Graphics instance.
     * @param text      The String to draw.
     * @param rect      The Rectangle to center the text in.
     * @param font      The font to use.
     * @param textColor The color of the text.
     * @param bgColor   The color of the background.
     * @author Yogesh Thambidurai
     * @author Ella Carlile
     * @see <a href=https://stackoverflow.com/a/27740330>https://stackoverflow.com/a/27740330</a>
     * @see <a href=https://stackoverflow.com/a/6416215>https://stackoverflow.com/a/6416215</a>
     */
    //Changed by Ella to somewhat center the text, which definitely didn't cause me pain.
    private void drawCenteredBackgroundedString(
            Graphics goon,
            String text,
            Rectangle rect,
            Font font,
            Color textColor,
            Color bgColor
    ) {
        // Get the FontMetrics
        FontMetrics metrics = goon.getFontMetrics(font);

        // Determine the X coordinate for the text

        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Get the Rectangle for the background
        //Rectangle2D bg = metrics.getStringBounds(text, goon);

        // Fill the background
        goon.setColor(bgColor);
        //goon.fillRect(x, y - (int) bg.getHeight(), (int) bg.getWidth(), (int) bg.getHeight());
        goon.fillRect(rect.x, rect.y, rect.width, rect.height);

        // Set the color
        goon.setColor(textColor);
        // Set the font
        goon.setFont(font);
        // Draw the String
        goon.drawString(text, x, rect.y + rect.height - ((metrics.getDescent() + metrics.getAscent()) / 2));
    }

    //Getters and Setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(Color buttonColor) {
        this.buttonColor = buttonColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
