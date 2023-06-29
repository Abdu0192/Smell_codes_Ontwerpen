import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class DrawTransactionUI {
    private Transactions transactions;
    private int maxPriceWidth = 0;
    private ButtonInterfacePositioner buttonPositioner = new ButtonPositioner();


    public void DrawTransactions(Graphics g, Transactions transactions, JButton addButton,int x,int y) {
        this.transactions = transactions;
        setGraphicsFont(g);
        iterateTransactions(g, transactions, x, y);
        buttonPositioner.positionButton(addButton, 400);
    }

    private void setGraphicsFont(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 14));
    }

    private void iterateTransactions(Graphics g, Transactions transactions, int x, int y) {
        for (Map.Entry<String, Double> transaction : transactions.getTranacties().entrySet()) {
            String transactionName = transaction.getKey();
            double price = transaction.getValue();
            drawTransaction(g,transactionName, price, x, y);
            y += 20;
        }
    }

    private void drawTransaction(Graphics g,  String transactionName, double price, int x, int y) {
        DrawUIUtils.drawLB(g, transactionName, x, y);
        updateMaxPriceWidth(price, g);
        DrawUIUtils.price(g, price, x, y, 210);
    }

    private void updateMaxPriceWidth(double price, Graphics g) {
        String priceString = String.format("%.2f", price);
        int priceWidth = g.getFontMetrics().stringWidth(priceString);
        if (priceWidth > maxPriceWidth) {
            maxPriceWidth = priceWidth;
        }
    }
}


