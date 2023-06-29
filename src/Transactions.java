import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Transactions {

    private HashMap<String, Double> transactions = new HashMap<>();

    public Transactions() {
        transactions.put("T-Shirt", 12.99);
        transactions.put("Jeans", 24.99);
        transactions.put("Sneakers", 49.99);
        transactions.put("Hamburger", 3.99);
        transactions.put("Pizza", 8.99);
        transactions.put("Sushi Roll", 11.99);
        transactions.put("Gold Necklace", 21.99);
        transactions.put("Diamond Earrings", 25.99);
        transactions.put("Leather Watch", 6.99);
    }

    public void SetTransacties(String transaction, double amount) {
        transactions.put(transaction, amount);
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

}
