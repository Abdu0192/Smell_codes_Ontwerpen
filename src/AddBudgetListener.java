import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddBudgetListener implements ActionListener {
    private Transactions transactions;
    private Budget budget;

    public AddBudgetListener(Transactions transactions, Budget budget) {
        this.transactions = transactions;
        this.budget = budget;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double transactionAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the budget amount:"));
        budget.setBudget(transactionAmount);
        budget.setCurrentBudget(budget.getBudget() - transactions.getTotalCost());
    }
}
