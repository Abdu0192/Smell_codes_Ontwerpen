package template;

import javax.swing.*;

public class Waarschuwingoptie extends BudgetWarningTemplate {
    @Override
    protected void showOverBudgetWarning() {
        JOptionPane.showMessageDialog(null, "Waarschuwing: Je bent ver over je budget!");
    }

    @Override
    protected void WithinLimit() {  JOptionPane.showMessageDialog(null, "Your are  doing Great :)");}
}
