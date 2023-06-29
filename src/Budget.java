import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Budget {
    private double budget=500;
    private double currentBudget;
    private Transactions transactions;

    public Budget() {
        transactions = new Transactions();
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
        updateCurrentBudget();
    }

    public double getCurrentBudget() {
        return currentBudget;
    }

    public void setCurrentBudget(double currentBudget) {
        this.currentBudget = currentBudget;
    }

    private void updateCurrentBudget() {
        currentBudget = budget - transactions.getTotalCost();
    }
}
