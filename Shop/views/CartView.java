package Shop.views;

import Shop.NavigationService;
import Shop.controllers.CartProductPanelController;
import Shop.controllers.ProductPanelController;
import Shop.formatting.CurrencyHelper;
import Shop.models.ListOfProducts;
import Shop.utility.LayoutHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CartView extends JPanel {

    private final NumberFormat currencyFormatter;

    private final JButton backMainButton;
    private final JButton clearCartButton;
    private final JButton checkOutButton;
    private final JLabel subTotalLabel;
    private final JLabel shippingFeeLabel;
    private final JLabel taxTotalLabel;
    private final JLabel totalPriceLabel;
    private final JLabel errorMessage;
    private final JScrollPane cartScrollPane;
    private final JPanel productInCartContainer;
    private ListOfProducts listOfProducts;
    private ArrayList<JPanel> AllProductInCartPanels = new ArrayList<>();

    public ListOfProducts getListOfProducts(){
        return listOfProducts;
    }


    public CartView(){

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        subTotalLabel = new JLabel("");
        taxTotalLabel = new JLabel("");
        shippingFeeLabel = new JLabel("");
        totalPriceLabel = new JLabel("");

        backMainButton = new JButton("BackMainPage");
        clearCartButton = new JButton("Clear Cart");
        checkOutButton = new JButton("CheckOut");

        errorMessage = createErrorLabel("");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createEmptyBorder());

        add(createButtonUpPage());

        add(createErrorMessagePanel());

        productInCartContainer = new JPanel();

        cartScrollPane = new JScrollPane(productInCartContainer,   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cartScrollPane.setPreferredSize(new Dimension(350, 420));

        add(cartScrollPane);

        add(LayoutHelper.createRigidArea());

        add(createSubTotalPanel());
        add(createTaxTotalPanel());
        add(createPShippingFeePanel());
        add(createTotalPricePanel());

        add(createButtonDownPage());

    }

    public void initialize(ListOfProducts listOfProducts){

        this.createAllProductInCartPanels(listOfProducts);


    }

    public void createAllProductInCartPanels(ListOfProducts listOfProducts){

        this.listOfProducts = listOfProducts;


        for (int i = 0; i < listOfProducts.AllAvailableProducts.size(); i++){

            CartProductPanel cartProductPanel = new CartProductPanel(listOfProducts.AllAvailableProducts.get(i));
            new CartProductPanelController(cartProductPanel, this);

            AllProductInCartPanels.add(cartProductPanel);

        }

        productInCartContainer.add(createProductContainer());
        //cartScrollPane.setPreferredSize(new Dimension(350, 420));
        cartScrollPane.setSize(350,420);

    }

    private JPanel createProductContainer(){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));


        for (JPanel allProductInCartPanel : AllProductInCartPanels) {
            panel.add(allProductInCartPanel);

        }

        return panel;

    }

    public void ClearCart(){
        productInCartContainer.removeAll();
        AllProductInCartPanels.clear();
        cartScrollPane.setSize(350,400);

    }

    private JPanel createErrorMessagePanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(LayoutHelper.createEmptyBorder());
        panel.add(errorMessage);
        return panel;
    }

    private static JLabel createErrorLabel(String text)
    {
        JLabel label = new JLabel(text);
        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
        label.setForeground(Color.RED);
        return label;
    }

    private JPanel createTotalPricePanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));


        panel.add(createValueLabel("total price : "));
        panel.add(totalPriceLabel);

        return panel;

    }

    private JPanel createSubTotalPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.add(createValueLabel("sub total : "));
        panel.add(subTotalLabel);

        return panel;

    }
    private JPanel createTaxTotalPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));


        panel.add(createValueLabel("tax total : "));
        panel.add(taxTotalLabel);

        return panel;

    }
    private  JPanel createPShippingFeePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.add(createValueLabel("shipping fee : "));
        panel.add(shippingFeeLabel);


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

    public void setSubTotalLabel(Double newSubTotal){
        subTotalLabel.setText(currencyFormatter.format(newSubTotal));
    }

    public void setTaxesLabel(Double newTaxes){
        taxTotalLabel.setText(currencyFormatter.format(newTaxes));
    }

    public void setShippingFeeLabel(Double newShippingFee){
        shippingFeeLabel.setText(currencyFormatter.format(newShippingFee));
    }

    public void setTotalPricelabel(Double newTotalPrice){
        totalPriceLabel.setText(currencyFormatter.format(newTotalPrice));
    }

    private static JLabel createValueLabel(String text)
    {
        JLabel label = new JLabel(text);
        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
        return label;
    }
    public void displayErrorMessage(boolean type, String message){
        if(!type){
            errorMessage.setForeground(Color.RED);
        }
        else{
            errorMessage.setForeground(Color.BLUE);
        }

        errorMessage.setText(message);

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
