import javax.swing.*;
import java.awt.*;

public class DrawBudgetUI {
    private UIFactory factory = new DefaultUIFactory();
    private ButtonInterfacePositioner buttonPositioner = new ButtonPositioner();


    public DrawBudgetUI( ) {

    }

    public void draw(Graphics g,JButton button,Budget budget ) {
        factory.drawLabel(g,  "Budget:", 110, 55);
        factory.drawPrice(g, budget.getBudget(), 280, 55, 110);
        factory.drawLabel(g, "Remaining Budget:", 110, 115);
        factory.drawPrice(g, budget.getCurrentBudget(), 280, 115, 110);
        buttonPositioner.positionButton(button, 280);
    }

}
