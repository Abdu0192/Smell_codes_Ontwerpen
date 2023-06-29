package template;

public abstract class BudgetWarningTemplate {
    public void CheckBudget(double currentBudget) {
        if (currentBudget < 0) {
            showOverBudgetWarning();
        }else {
            WithinLimit();
        }
    }
    protected abstract void showOverBudgetWarning();
    protected abstract void WithinLimit();
    public void displayBudgetWarning(double currentBudget) {
        CheckBudget(currentBudget);
    }
    }
