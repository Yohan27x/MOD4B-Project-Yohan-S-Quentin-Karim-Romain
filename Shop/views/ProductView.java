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

    private JButton NextProductPage;
    private JButton PreviousProductPage;

    private int debutRangeProduct = 0;
    private int endRangeProduct = 4;
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
    private ArrayList<JPanel> AllProductPanels = new ArrayList<>();
    private ListOfProducts listOfProducts = new ListOfProducts();


    public ProductView() {

        NextProductPage = new JButton("NextProductPage");
        PreviousProductPage = new JButton("PreviousProductPage");
        BackMainMenu = new JButton("BackMainMenu");
        AccesCart = new JButton("AccesCart");

        add(createButtonsPanel());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        this.createAllProductPanels(listOfProducts);

        for (int i = debutRangeProduct; i < endRangeProduct; i++) {
            add(AllProductPanels.get(i)); // remplacer par initialize()

        }


        add(createProductBrowseButtonsPanel());
    }

    public void initialize(ListOfProducts listOfShopProducts) {

        listOfProducts = listOfShopProducts;

        this.createAllProductPanels(listOfProducts);

        for (int i = debutRangeProduct; i < endRangeProduct; i++) {
            add(AllProductPanels.get(i)); // remplacer par initialize()

        }

    }

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

        AddToCart = new JButton("Add to cart");
        ProductName = new JLabel(product.getName());
        ProductImage = new JLabel();
        ImageIcon icon = new ImageIcon(new ImageIcon(product.getImagePath()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
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
        //panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(LayoutHelper.createEmptyBorder());


        panel.add(PreviousProductPage);
        panel.add(LayoutHelper.createRigidArea());
        panel.add(NextProductPage);

        return panel;
    }

    private JPanel createButtonsPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 10, 10));

        panel.add(BackMainMenu);
        panel.add(LayoutHelper.createRigidArea());
        //panel.setBorder(LayoutHelper.createLargeEmptyBorder());
        panel.add(AccesCart);

        return panel;
    }

}
