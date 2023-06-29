import java.awt.*;

public class DrawUIUtils {
    public static void drawLB(Graphics g, String label, int x, int y) {
        g.setColor(Color.black);
        g.drawString(label, x, y);
    }

    public static void price(Graphics g, double price, int x, int y, int maxWidth) {
        String priceString = String.format("%.2f", price);
        int priceX = x + maxWidth - g.getFontMetrics().stringWidth(priceString);
        g.drawString(priceString, priceX, y);
    }



}

