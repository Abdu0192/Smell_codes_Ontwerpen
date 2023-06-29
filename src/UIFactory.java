import javax.swing.*;
import java.awt.*;
abstract class UIFactory {
    public abstract JLabel createLabel(String text);

    public abstract JButton createButton(String text);

    public abstract void drawLabel(Graphics g, String label, int x, int y);

    public abstract void drawPrice(Graphics g, double price, int x, int y, int maxWidth);
}