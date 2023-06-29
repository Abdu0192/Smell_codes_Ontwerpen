import java.awt.*;

import javax.swing.*;

public class BudgetApp extends JPanel {
    private Transactions transactions;
    private Budget budget = new Budget();
    private DrawTransactionUI ui;
    private DrawBudgetUI budgetui;
    private JButton addButton;
    private JButton budgetButton;
    private AddTransactionListener  TL;
    private AddBudgetListener  DL;


    public BudgetApp() {
        this.transactions = new Transactions();
        this.ui = new DrawTransactionUI();
        this.budgetui = new DrawBudgetUI();
        this.TL = new AddTransactionListener(transactions, budget);
        this.DL = new AddBudgetListener(transactions, budget);

        addButton = new DefaultUIFactory().createButton("Add Transaction");
        addButton.addActionListener(TL);

        budgetButton = new DefaultUIFactory().createButton("Add Budget");
        budgetButton.addActionListener(new AddBudgetListener(transactions, budget));

        add(addButton);
        add(budgetButton);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        budgetui.draw(g, budgetButton,budget);
        ui.DrawTransactions(g, transactions, addButton,505,40);
        repaint();
    }
}