import javax.swing.*;
import java.awt.*;

public class ButtonPositioner implements ButtonInterfacePositioner {
    @Override
    public void positionButton(JButton button, int x) {
        button.setBounds(150, x, 200, 30);
    }
}


