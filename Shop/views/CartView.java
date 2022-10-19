package Shop.views;

import Shop.NavigationService;
import Shop.controllers.CartProductPanelController;
import Shop.controllers.ProductPanelController;
import Shop.models.ListOfProducts;
import Shop.utility.LayoutHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CartView extends JPanel {

    private final JButton backMainButton;
    private final JButton clearCartButton;
    private final JButton checkOutButton;

    private final JLabel subTotal;
    private final JLabel taxTotal;
    private final JLabel totalPrice;
    private final JScrollPane cartScrollPane;

    private final JPanel productInCartContainer;
    private ListOfProducts listOfProducts = new ListOfProducts();

    private ArrayList<JPanel> AllProductInCartPanels = new ArrayList<>();
    // todo ajouter scrollPane
    // todo créer component panel


    public CartView(){

        subTotal = new JLabel("subtotal");
        taxTotal = new JLabel("taxtotal");
        totalPrice = new JLabel("totalprice");

        backMainButton = new JButton("BackMainPage");
        clearCartButton = new JButton("Clear Cart");
        checkOutButton = new JButton("CheckOut");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createEmptyBorder());

        add(createButtonUpPage());


        productInCartContainer = new JPanel();

        cartScrollPane = new JScrollPane(productInCartContainer,   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cartScrollPane.setPreferredSize(new Dimension(350, 420));

        add(cartScrollPane);

        add(createPriceLabelMain());
        add(createButtonDownPage());

    }

    public void initialize(ListOfProducts listOfProducts){

        this.createAllProductInCartPanels(listOfProducts);


    }

    public void createAllProductInCartPanels(ListOfProducts listOfProducts){

        for (int i = 0; i < listOfProducts.AllAvailableProducts.size(); i++){

            CartProductPanel cartProductPanel = new CartProductPanel(listOfProducts.AllAvailableProducts.get(i));
            new CartProductPanelController(cartProductPanel);

            AllProductInCartPanels.add(cartProductPanel);

        }

        productInCartContainer.add(createProductContainer());

    }

    private JPanel createProductContainer(){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        for(int i = 0; i < AllProductInCartPanels.size(); i++){
            panel.add(AllProductInCartPanels.get(i));

        }

        return panel;

    }

    public void ClearCart(){
        productInCartContainer.removeAll();
        AllProductInCartPanels.clear();

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
        panel.add(checkOutButton);


        return panel;
    }

    public void addBackMainListener(ActionListener listener)
    {
        backMainButton.addActionListener(listener);
    }
    public void addClearCartListener(ActionListener listener)
    {
        clearCartButton.addActionListener(listener);
    }

    public void addCheckOutListener(ActionListener listener)
    {
        checkOutButton.addActionListener(listener);
    }


}
