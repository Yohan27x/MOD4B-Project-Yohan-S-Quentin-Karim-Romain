package Shop.views;

import Shop.NavigationService;
import Shop.models.ListOfProducts;
import Shop.utility.LayoutHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartView extends JPanel {

    private final JButton backMainButton;
    private final JButton clearCartButton;
    private final JButton CheckOutButton;

    private final JLabel subTotal;
    private final JLabel taxTotal;
    private final JLabel totalPrice;
    private final JScrollPane cartScrollPane;
    private ListOfProducts listOfProducts = new ListOfProducts();
    // todo ajouter scrollPane
    // todo créer component panel


    public CartView(){



        subTotal = new JLabel("subtotal");
        taxTotal = new JLabel("taxtotal");
        totalPrice = new JLabel("totalprice");

        backMainButton = new JButton("BackMainPage");
        clearCartButton = new JButton("Clear Cart");
        CheckOutButton = new JButton("CheckOut");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createEmptyBorder());

        add(createButtonUpPage());

        CartProductPanel cartProductPanel1 = new CartProductPanel(listOfProducts.AllAvailableProducts.get(0));
        CartProductPanel cartProductPanel2 = new CartProductPanel(listOfProducts.AllAvailableProducts.get(0));
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));


        container.add(cartProductPanel1);
        container.add(cartProductPanel2);


        cartScrollPane = new JScrollPane(container,   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        cartScrollPane.setPreferredSize(new Dimension(350, 420));

        add(cartScrollPane);

        add(createPriceLabelMain());
        add(createButtonDownPage());

    }

    private  JPanel createTitle(JLabel text) {
        JPanel panel = new JPanel();
        panel.setBorder(LayoutHelper.createEmptyBorder());

        panel.add(text);

        return panel;
    }


    private  JPanel createPriceLabelMain() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(subTotal);
        panel.add(LayoutHelper.createRigidArea());
        panel.add(taxTotal);
        panel.add(LayoutHelper.createRigidArea());
        panel.add(totalPrice);

        return panel;
    }

    private  JPanel createButtonUpPage() {
        JPanel panel = new JPanel();

        panel.setBorder(LayoutHelper.createEmptyBorder());
        panel.add(backMainButton);



        return panel;
    }

    private  JPanel createButtonDownPage() {
        JPanel panel = new JPanel();

        // add layout

        panel.setBorder(LayoutHelper.createEmptyBorder());

        panel.add(clearCartButton);
        panel.add(CheckOutButton);


        return panel;
    }

    public void addBackMainListener(ActionListener listener)
    {
        backMainButton.addActionListener(listener);
    }

}
