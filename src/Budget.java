import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Budget {

    private double budget;

    private double inkomst;
    private Transactions transactions;
    private double currentBudget;
    public Budget(double budget) {
        this.budget = budget;
        this.currentBudget = budget;
        transactions = new Transactions();
        currentBudget = budget - transactions.getTotalCost();
    }
    public double getBudget() {
       return budget;
    }
    public void setInkomst(double inkomst) {
        this.inkomst=inkomst;
    }
    public void setBudget(double budget) {
        this.budget = budget;
        this.currentBudget = budget;
    }

    public void setCurrentBudget(double currentBudget) {
        this.currentBudget = currentBudget;
        Budget Waarschuwing  = new OverBudgetWaarschuwing(budget);
        ((OverBudgetWaarschuwing) Waarschuwing).CheckBudgetisOnder0(currentBudget);
    }

    public double getCurrentBudget() {
        return currentBudget;
    }


    public void draw(Graphics g, JButton button, JButton inkomstButton) {
        // Set up colors and fonts
        Color backgroundColor = Color.WHITE;
        Color textColor = Color.BLACK;
        Font font = new Font("Arial", Font.PLAIN, 14);
        g.setFont(font);

        // Draw budget rectangle
        int x = 100;
        int y = 40;
        int width = 200;
        int height = 30;
        g.setColor(Color.GREEN); // Change color to green
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK); // Change color back to black for border
        g.drawRect(x, y, width, height); // Draw border

        // Draw budget label
        g.setColor(textColor);
        String budgetLabel = "Budget:";
        int labelX = x + 10; // adjust the x-position for the label
        int labelY = y + height/2 + g.getFontMetrics().getAscent()/2;
        g.drawString(budgetLabel, labelX, labelY);

        // Draw budget amount
        String budgetString = String.format("$%.2f", budget);
        int amountX = x + width - g.getFontMetrics().stringWidth(budgetString) - 10; // adjust the x-position for the amount
        g.drawString(budgetString, amountX, labelY);

        // Draw inkomst rectangle
        y += height + 20;
        g.setColor(Color.YELLOW); // Change color to yellow
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK); // Change color back to black for border
        g.drawRect(x, y, width, height); // Draw border

        // Draw inkomst label
        g.setColor(textColor);
        String inkomstLabel = "Inkomst:";
        labelY = y + height/2 + g.getFontMetrics().getAscent()/2;
        g.drawString(inkomstLabel, labelX, labelY);

        // Draw inkomst amount
        String inkomstString = String.format("$%.2f", inkomst);
        amountX = x + width - g.getFontMetrics().stringWidth(inkomstString) - 10; // adjust the x-position for the amount
        g.drawString(inkomstString, amountX, labelY);

        // Calculate remaining budget
        double remainingBudget = currentBudget - transactions.getTotalCost();

        // Draw remaining budget rectangle
        y += height + 20;
        g.setColor(Color.GREEN); // Change color to green
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK); // Change color back to black for border
        g.drawRect(x, y, width, height); // Draw border

        // Draw remaining budget label
        g.setColor(textColor);
        String remainingBudgetLabel = "Remaining Budget:";
        labelY = y + height/2 + g.getFontMetrics().getAscent()/2;
        g.drawString(remainingBudgetLabel, labelX, labelY);

        // Draw remaining budget amount
        String remainingBudgetString = String.format("$%.2f", getCurrentBudget());
        amountX = x + width - g.getFontMetrics().stringWidth(remainingBudgetString) - 10; // adjust the x-position for the amount
        g.drawString(remainingBudgetString, amountX, labelY);

        // Position the buttons under the remaining budget rectangle
        int buttonY = y + height + 20; // set the button Y position to the bottom of the remaining budget rectangle plus a margin
        int buttonWidth = 100; // set the button width
        int buttonHeight = 30; // set the button height
        button.setBounds(x + width/2 - buttonWidth/2, buttonY, buttonWidth, buttonHeight); // set the budget button position and size
        inkomstButton.setBounds(x + width/2 - buttonWidth/2, buttonY + buttonHeight + 10, buttonWidth, buttonHeight); // set the income button position and size

    }


}
