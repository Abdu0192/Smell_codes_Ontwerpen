package template;

import javax.swing.JOptionPane;

public class Waarschuwingoptie2 extends BudgetWarningTemplate {
    @Override
    protected void showOverBudgetWarning() {
        JOptionPane.showMessageDialog(null, "Waarschuwing: je bent over je budget!");
    }

    @Override
    protected void WithinLimit() {
        JOptionPane.showMessageDialog(null, "You are doing great.");
    }
}

