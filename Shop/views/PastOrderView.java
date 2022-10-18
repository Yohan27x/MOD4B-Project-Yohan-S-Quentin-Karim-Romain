package Shop.views;

import Shop.utility.LayoutHelper;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PastOrderView extends JPanel {

    private final JButton backMainButton;

    public PastOrderView(){

        backMainButton = new JButton("BackMainPage");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(createTitle(new JLabel("Your Past Orders")));
        add(createButtonBackMain());
    }

    private  JPanel createTitle(JLabel text) {
        JPanel panel = new JPanel();
        panel.add(text);
        panel.setBorder(LayoutHelper.createEmptyBorder());

        return panel;
    }

    private  JPanel createButtonBackMain() {
        JPanel panel = new JPanel();

        panel.add(backMainButton);
        panel.setBorder(LayoutHelper.createEmptyBorder());

        return panel;
    }

    public void addBackMainListener(ActionListener listener)
    {
        backMainButton.addActionListener(listener);
    }

}
