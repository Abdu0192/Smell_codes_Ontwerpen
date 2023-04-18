import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class test {

    @Test
    public void testGetTotalCost() {
        Transactions transactions = new Transactions();
        //
        double expectedTotalCost = 167.91;
        double actualTotalCost = transactions.getTotalCost();
        assertEquals(expectedTotalCost, actualTotalCost, 0.001);
    }
    @Test
    public void testBudget(){
        Budget budget = new Budget(500);
        assertEquals(budget.getBudget(),500, 0.001);
    }

    @Test
  public   void testSetTransacties() {
        Transactions transactions = new Transactions();
        transactions.SetTransacties("New transaction", 10.99);
        HashMap<String, Double> expectedTransactions = new HashMap<>(transactions.getTranacties());
        expectedTransactions.put("New transaction", 10.99);
        assertEquals(expectedTransactions, transactions.getTranacties());
    }
}