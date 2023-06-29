import template.BudgetWarningTemplate;
import template.Waarschuwingoptie;
import template.Waarschuwingoptie2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTransactionListener implements ActionListener {
    private Transactions transactions;
    private Budget budget;
    private BudgetWarningTemplate budgetWarningTemplate = new Waarschuwingoptie();

    public AddTransactionListener (Transactions transactions, Budget budget) {
        this.transactions = transactions;
        this.budget = budget;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String transactionName = JOptionPane.showInputDialog(null, "Enter the transaction name:");
        double transactionAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the transaction amount:"));
        transactions.SetTransacties(transactionName, transactionAmount);
        budget.setCurrentBudget(budget.getBudget() - transactions.getTotalCost());
        budgetWarningTemplate.displayBudgetWarning(budget.getCurrentBudget());

    }

}