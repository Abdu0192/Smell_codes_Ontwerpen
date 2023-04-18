import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Transactions {

    private HashMap<String, ArrayList<String>> categories = new HashMap<>();
    private HashMap<String, Double> transactions = new HashMap<>();
    private Random rand = new Random();

    public Transactions() {
        categories.put("Clothing", new ArrayList<String>());
        categories.put("Food", new ArrayList<String>());
        categories.put("Jewelry", new ArrayList<String>());
        categories.put("Watches", new ArrayList<String>());

        transactions.put("T-Shirt", 12.99);
        transactions.put("Jeans", 24.99);
        transactions.put("Sneakers", 49.99);
        transactions.put("Hamburger", 3.99);
        transactions.put("Pizza", 8.99);
        transactions.put("Sushi Roll", 11.99);
        transactions.put("Gold Necklace", 21.99);
        transactions.put("Diamond Earrings", 25.99);
        transactions.put("Leather Watch", 6.99);
        // Assign each transaction to the correct category
        for (Map.Entry<String, Double> transaction : transactions.entrySet()) {
            String transactionName = transaction.getKey();
            Double transactionPrice = transaction.getValue();
            String category;
            // Determine the category based on the transaction name
            if (transactionName.contains("T-Shirt") || transactionName.contains("Jeans") || transactionName.contains("Sneakers")) {category = "Clothing";
            } else if (transactionName.contains("Hamburger") || transactionName.contains("Pizza") || transactionName.contains("Sushi Roll")) {category = "Food";
            } else if (transactionName.contains("Gold Necklace") || transactionName.contains("Diamond Earrings")) {category = "Jewelry";
            } else if (transactionName.contains("Leather Watch")) {category = "Watches";
            } else {category = "Uncategorized";}
            // Add the transaction to the correct category
            categories.get(category).add(transactionName);
        }
    }

    public void SetTransacties(String transaction, double amount) {
        transactions.put(transaction, amount);

        // Assign the new transaction to a random category
        int index = rand.nextInt(categories.size());
        String category = (String) categories.keySet().toArray()[index];
        categories.get(category).add(transaction);
    }

    public HashMap<String, ArrayList<String>> getCategories() {
        return categories;
    }

    public HashMap<String, Double> getTranacties() {
        return transactions;
    }

    public double getTotalCost() {
        double total = 0.0;
        for (Double cost : transactions.values()) {
            total += cost;
        }
        return total;
    }



    public  void DrawTransactions(Graphics g, Transactions transactions, JButton addButton,JTextArea textArea) {
        Color backgroundColor = Color.WHITE;
        Color textColor = Color.BLACK;
        Font font = new Font("Arial", Font.PLAIN, 14);
        g.setFont(font);

        HashMap<String, ArrayList<String>> categoriesMap = transactions.getCategories();
        int y = 40;
        int maxPriceWidth = 0;
        int rectangleWidth = 200 + 10;
        int rectangleHeight = 20;
        int Xposition = 500;
        int padding = 5;

        for (String category : categoriesMap.keySet()) {
            // Draw category title
            g.setColor(Color.BLACK);  g.drawString(category, Xposition, y); y += 20;
            // Draw transactions in the category
            ArrayList<String> transactionsList = categoriesMap.get(category);
            for (String transaction : transactionsList) {
                String transactionString = transaction + " - " + transactions.getTranacties().get(transaction);

                // Draw a rectangle for the background
                g.setColor(backgroundColor);
                g.fillRect(Xposition, y - rectangleHeight + padding, rectangleWidth, rectangleHeight);
                g.setColor(Color.BLACK);
                g.drawRect(Xposition, y - rectangleHeight + padding, rectangleWidth, rectangleHeight);

                // Draw the transaction string
                g.setColor(textColor);
                g.drawString(transaction, Xposition + padding, y);

                // Determine the X position coordinate of the price string
                double price = transactions.getTranacties().get(transaction);
                String priceString = String.format("%.2f", price);
                int priceWidth = g.getFontMetrics().stringWidth(priceString);
                if (priceWidth > maxPriceWidth) {
                    maxPriceWidth = priceWidth;
                }
                int priceX = Xposition + rectangleWidth - padding - priceWidth;
                g.drawString(priceString, priceX, y);

                y += 20;
            } y += 20; // Add empty space after each category
        }
// Add button and text area at the end
        addButton.setBounds(Xposition, y + 50, 200, 30);
        textArea.setLocation(Xposition, y + 20);
    }

}
