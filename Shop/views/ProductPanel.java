package Shop.views;

import Shop.models.Product;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductPanel extends JPanel {

    private final JLabel errorMessage;

    private final JButton AddToCart;
    private final JLabel ProductName;
    private final JLabel ProductImage;
    private final JLabel ProductPrice;
    private final JLabel ProductDescription;

    private final JLabel ProductSKU;
    private final JLabel ProductCategory;
    private final JLabel ProductQuantityLeft;
    private final JLabel ProductQuantityChoosen;
    private final JButton increaseQuantity;
    private final JButton decreaseQuantity;
    private static final int WIDTH = 55;
    private static final int HEIGHT = 55;


    public ProductPanel(Product product){

        Border raisedetched;
        raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        setBorder(raisedetched);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();



        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.HORIZONTAL;

        errorMessage = createErrorLabel("");

        ProductImage = new JLabel();
        ImageIcon icon = new ImageIcon(new ImageIcon(product.getImagePath()).getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT));
        ProductImage.setIcon(icon);
        ProductName = new JLabel(product.getName());
        ProductPrice = new JLabel(product.getStringPrice());
        ProductDescription = new JLabel(product.getDescription());
        ProductQuantityLeft = new JLabel(product.getStringQuantity());
        ProductQuantityChoosen = new JLabel("1");
        ProductCategory = new JLabel(product.getCategory());
        ProductSKU = new JLabel(product.getStringSku());

        decreaseQuantity = new JButton("Decrease");
        increaseQuantity = new JButton("Increase");
        AddToCart = new JButton("Add to cart");


        c.gridx = 0;
        c.gridy = 0;
        add(ProductImage, c);

        c.gridx = 0;
        c.gridy = 3;
        add(createValueLabel("Name : "), c);

        c.gridx = 1;
        c.gridy = 3;
        add(ProductName, c);

        c.gridx = 0;
        c.gridy = 4;
        add(createValueLabel("Category : "), c);

        c.gridx = 1;
        c.gridy = 4;
        add(ProductCategory, c);

        c.gridx = 0;
        c.gridy = 5;
        add(createValueLabel("Price : "), c);

        c.gridx = 1;
        c.gridy = 5;
        add(ProductPrice, c);

        c.gridx = 0;
        c.gridy = 6;
        add(createValueLabel("Description : "), c);

        c.gridx = 1;
        c.gridy = 6;
        add(ProductDescription, c);

        c.gridx = 1;
        c.gridy = 0;
        add(errorMessage, c);

        c.gridx = 1;
        c.gridy = 1;
        add(createValueLabel("Quantity left : "), c);

        c.gridx = 4;
        c.gridy = 1;
        add(ProductQuantityLeft, c);

        c.gridx = 1;
        c.gridy = 2;
        add(createValueLabel("Choosen Quantity : "), c);

        c.gridx = 4;
        c.gridy = 2;
        add(ProductQuantityChoosen, c);



        c.ipady = 0;
        c.gridx = 4;
        c.gridy = 3;
        add(increaseQuantity, c);

        c.gridx = 4;
        c.gridy = 4;
        add(decreaseQuantity, c);

        c.ipady = 10;
        c.gridx = 4;
        c.gridy = 6;
        add(AddToCart, c);

    }

    private static JLabel createValueLabel(String text)
    {
        JLabel label = new JLabel(text);
        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
        return label;
    }

    private static JLabel createErrorLabel(String text)
    {
        JLabel label = new JLabel(text);
        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
        label.setForeground(Color.RED);
        return label;
    }

    public void displayErrorMessage(String message)
    {
        errorMessage.setText(message);
    }



    //ProductName = new JLabel(product.getName());
    //ProductPrice = new JLabel(product.getStringPrice());
    //ProductDescription = new JLabel(product.getDescription());
    //ProductQuantityLeft = new JLabel(product.getStringQuantity());
    //ProductQuantityChoosen = new JLabel("1");
    //ProductCategory = new JLabel(product.getCategory());
    //ProductSKU = new JLabel(product.getStringSku());
    public String getProductName(){
        return ProductName.getText();
    }

    public String getProductPrice(){
        return ProductPrice.getText();
    }

    public String getProductQuantityLeft(){
        return ProductQuantityLeft.getText();
    }

    public String getProductQuantityChoosen(){
        return ProductQuantityChoosen.getText();
    }

    public String getProductCategory(){
        return ProductCategory.getText();
    }

    public String getProductSKU(){
        return ProductSKU.getText();
    }

    public void setProductQuantityChoosen(String newQuantityChoosen){
        ProductQuantityChoosen.setText(newQuantityChoosen);
    }

    public void setProductQuantityLeft(String newQuantityLeft){
        ProductQuantityLeft.setText(newQuantityLeft);
    }

    public void addIncreaseQuantityListener(ActionListener listener){increaseQuantity.addActionListener(listener);}
    public void addDecreaseQuantityListener(ActionListener listener){decreaseQuantity.addActionListener(listener);}
    public void addAddToCartListener(ActionListener listener){AddToCart.addActionListener(listener);}






}
