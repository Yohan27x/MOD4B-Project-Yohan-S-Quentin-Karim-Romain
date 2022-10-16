package Shop.views;


import javax.imageio.ImageIO;
import javax.swing.*;

import Shop.models.ListOfProducts;
import Shop.utility.LayoutHelper;
import Shop.models.Product;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ProductView extends JPanel {

    private JTextField filterNameTextField;
    private JButton BackMainMenu;
    private JButton AccesCart;
    private JButton AddToCart;
    private JLabel ProductName;
    private JLabel ProductImage;
    private JLabel ProductPrice;
    private JLabel ProductDescription;
    private JLabel ProductSKU;
    private JLabel ProductCategory;
    private JLabel ProductQuantity;

    private int widthImage = 40;

    private int heightImage = 40;
    private JLabel Page;
    private int pageNumber = 1;
    private int maxPageNumber = 1;
    private JButton NextProductPageButton;
    private JButton PreviousProductPageButton;
    private int debutRangeProduct = 0;
    private int endRangeProduct = 3;

    private ArrayList<JPanel> AllProductPanels = new ArrayList<>();
    private ListOfProducts listOfProducts = new ListOfProducts();


    public ProductView() {

        NextProductPageButton = new JButton("NextProductPage");
        PreviousProductPageButton  = new JButton("PreviousProductPage");
        BackMainMenu = new JButton("BackMainMenu");
        AccesCart = new JButton("AccesCart");

        filterNameTextField = new JTextField();

        add(createButtonsPanel());

        add(createFilterPanel());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        this.createAllProductPanels(listOfProducts);

        for (int i = debutRangeProduct; i < endRangeProduct; i++) {
            add(AllProductPanels.get(i)); // remplacer par initialize()
        }

        add(createProductBrowseButtonsPanel());
    }

    /*
    public void initialize(ListOfProducts listOfShopProducts) {

        listOfProducts = listOfShopProducts;

        this.createAllProductPanels(listOfProducts);

        for (int i = debutRangeProduct; i < endRangeProduct; i++) {
            add(AllProductPanels.get(i)); // remplacer par initialize()

        }

    }
    */


    private void createAllProductPanels(ListOfProducts listOfProducts){

        for (int i = 0; i < listOfProducts.AllAvailableProducts.size(); i++){

            JPanel ProductPanel = new JPanel();
            ProductPanel = createProductPanel(listOfProducts.AllAvailableProducts.get(i));

            AllProductPanels.add(ProductPanel);

        }

    }

    private JPanel createProductPanel(Product product)
    {
        JPanel panel = new JPanel();

        // use grid layout

        AddToCart = new JButton("Add to cart");
        ProductName = new JLabel(product.getName());
        ProductImage = new JLabel();
        ImageIcon icon = new ImageIcon(new ImageIcon(product.getImagePath()).getImage().getScaledInstance(widthImage, heightImage, Image.SCALE_DEFAULT));
        ProductImage.setIcon(icon);
        ProductPrice = new JLabel(product.getStringPrice());
        ProductDescription = new JLabel(product.getDescription());
        ProductSKU = new JLabel(product.getStringSku());
        ProductQuantity = new JLabel(product.getStringQuantity());
        ProductCategory = new JLabel(product.getCategory());

        panel.add(ProductImage);
        //panel.add(LayoutHelper.createSmallRigidArea());
        panel.setBorder(LayoutHelper.addSmallPadding(LayoutHelper.createSmallEmptyBorder()));
        panel.add(ProductName);
        panel.add(LayoutHelper.createSmallRigidArea());
        panel.add(ProductPrice);
        panel.add(LayoutHelper.createSmallRigidArea());
        panel.add(ProductQuantity);
        panel.add(LayoutHelper.createSmallRigidArea());
        panel.add(ProductSKU);
        panel.add(LayoutHelper.createSmallRigidArea());
        panel.add(ProductDescription);
        panel.add(LayoutHelper.createSmallRigidArea());
        panel.add(ProductCategory);
        panel.add(AddToCart);

        return panel;
    }

    private JPanel createProductBrowseButtonsPanel()
    {
        JPanel panel = new JPanel();


        Page = new JLabel(pageNumber + "");
        panel.add(PreviousProductPageButton);
        panel.add(LayoutHelper.createRigidArea());
        panel.add(Page);
        panel.add(new JLabel("/"));
        panel.add(new JLabel(maxPageNumber + ""));
        panel.add(LayoutHelper.createRigidArea());
        panel.add(NextProductPageButton);

        return panel;
    }

    public void increasePageNumber(){
        // vérifier qu'on est toujours en dessous
        Page.setText(++pageNumber +"") ;
        System.out.println(pageNumber);
    }

    public void decreasePageNumber(){
        if(pageNumber > 1){
            Page.setText(--pageNumber +"") ;
            System.out.println(pageNumber);
        }
    }

    private JPanel createButtonsPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 10, 10));


        panel.add(BackMainMenu);
        panel.add(LayoutHelper.createRigidArea());
        panel.setBorder(LayoutHelper.addMargin(LayoutHelper.createEmptyBorder()));
        panel.add(AccesCart);


        return panel;
    }



    private JPanel createFilterPanel(){

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 1, 1));

        panel.add(new JLabel("Name"));
        panel.add(filterNameTextField);
        panel.add(new JLabel("Category"));

        panel.setBorder(LayoutHelper.addSmallMargin(LayoutHelper.createEmptyBorder()));

        String[] values = {"1","2","3"};
        JComboBox categoryFilter = new JComboBox(values);
        categoryFilter.setBounds(100,100,100,30);

        panel.add(categoryFilter);


        return panel;

    }




    public void addNextPageListener(ActionListener listener)
    {
        NextProductPageButton.addActionListener(listener);
    }

    public void addPreviousPageListener(ActionListener listener)
    {
        PreviousProductPageButton.addActionListener(listener);
    }



}
