import javax.swing.*;
import java.awt.*;


public class DefaultUIFactory extends UIFactory {
    @Override
    public void drawLabel(Graphics g, String label, int x, int y) {
        DrawUIUtils.drawLB(g, label, x, y);
    }

    @Override
    public void drawPrice(Graphics g, double price, int x, int y, int maxWidth) {
        DrawUIUtils.price(g, price, x, y, maxWidth);
    }

    @Override
    public JLabel createLabel(String text) {
        return new JLabel(text);
    }

    @Override
    public JButton createButton(String text) {
        return new JButton(text);
    }
}