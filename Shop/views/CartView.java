package Shop.views;

import Shop.NavigationService;
import Shop.utility.LayoutHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartView extends JPanel {

    private final JButton backMainButton;
    private final JButton clearCartButton;
    private final JButton CheckOutButton;

    public CartView(){

        backMainButton = new JButton("BackMainPage");
        clearCartButton = new JButton("Clear Cart");
        CheckOutButton = new JButton("CheckOut");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(createTitle(new JLabel("Your Cart")));
        add(createButtonBackMain());
    }

    private  JPanel createTitle(JLabel text) {
        JPanel panel = new JPanel();
        panel.setBorder(LayoutHelper.createEmptyBorder());

        panel.add(text);

        return panel;
    }

    private  JPanel createButtonBackMain() {
        JPanel panel = new JPanel();

        // add layout

        panel.setBorder(LayoutHelper.createEmptyBorder());

        panel.add(backMainButton);
        panel.add(clearCartButton);
        panel.add(CheckOutButton);


        return panel;
    }

    public void addBackMainListener(ActionListener listener)
    {
        backMainButton.addActionListener(listener);
    }

}
