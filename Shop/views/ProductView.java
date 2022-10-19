package Shop.views;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Shop.controllers.ProductPanelController;
import Shop.models.ListOfProducts;
import Shop.utility.LayoutHelper;
import Shop.models.Product;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductView extends JPanel {

    private JTextField filterNameTextField;
    private JButton activeFilter;
    private JComboBox categoryFilter;
    private final JLabel errorMessage;
    private JButton BackMainMenu;
    private JButton accesCart;

    private JButton AddToCartFirst;
    private JButton AddToCartSecond;
    private JButton[] AddToCartButtons;

    private int chooseRightAddCartButton = 0;
    private JLabel ProductName;
    private JLabel ProductImage;
    private JLabel ProductPrice;
    private JLabel ProductDescription;
    private JLabel ProductSKU;
    private JLabel ProductCategory;
    private JLabel ProductQuantityLeft;
    private JLabel ProductQuantityChoosen;
    private JButton increaseQuantity;
    private JButton decreaseQuantity;
    private JPanel productsContainer;
    private int widthImage = 55;
    private int heightImage = 55;
    private JLabel firstPageNumber;
    private JLabel lastPageNumber;
    private int pageNumber = 1;
    private int maxPageNumber;
    private int productPerPage = 2;
    private JButton NextProductPageButton;
    private JButton PreviousProductPageButton;
    private int debutRangeProduct = 0;
    private int endRangeProduct = 1;
    private ArrayList<JPanel> AllProductPanels = new ArrayList<>();

    //private ArrayList<ProductPanelController> productPanelControllers = new ArrayList<>();
    private ListOfProducts listOfProducts = new ListOfProducts();
    private ArrayList<String> productCategory = new ArrayList<>();




    public ProductView() {

        NextProductPageButton = new JButton("NextProductPage -->");
        PreviousProductPageButton  = new JButton("<-- PreviousProductPage");
        BackMainMenu = new JButton("BackMainMenu");
        accesCart = new JButton("AccesCart");
        activeFilter = new JButton("Active filter");
        filterNameTextField = new JTextField();

        errorMessage = createErrorLabel("");

        firstPageNumber = createValueLabel(pageNumber + "");
        lastPageNumber = createValueLabel("");


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(createButtonsPanel());
        add(createFilterPanel());
        add(createErrorMessagePanel());

        this.createAllProductPanels(listOfProducts);

        productsContainer = new JPanel();
        productsContainer.add(createProductContainer());
        add(productsContainer);

        add(createProductBrowseButtonsPanel());
    }

    public void initialize(ListOfProducts listOfProducts){
        this.listOfProducts = listOfProducts;
        this.productCategory.clear();

        for (int i = 0; i < listOfProducts.AllAvailableProducts.size(); i++){
            if(!this.productCategory.contains(listOfProducts.AllAvailableProducts.get(i).getCategory())){
                this.productCategory.add(listOfProducts.AllAvailableProducts.get(i).getCategory());
            }
        }

        maxPageNumber = ((listOfProducts.AllAvailableProducts.size())/productPerPage);
        //System.out.println("max page number : " + maxPageNumber);
        lastPageNumber.setText(maxPageNumber + "");

        DefaultComboBoxModel<String> modelCategoryBox = new DefaultComboBoxModel<>( productCategory.toArray(new String[0]) );
        categoryFilter.setModel(modelCategoryBox);

    }

    private JPanel createProductContainer(){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        for (int i = debutRangeProduct; i <= endRangeProduct; i++) {
            panel.add(AllProductPanels.get(i));
            panel.add(LayoutHelper.createRigidArea());
        }

        return panel;

    }


    private void createAllProductPanels(ListOfProducts listOfProducts){

        for (int i = 0; i < listOfProducts.AllAvailableProducts.size(); i++){

            //JPanel productPanel;
            //productPanel = createProductPanel(listOfProducts.AllAvailableProducts.get(i));
            ProductPanel productPanel = new ProductPanel(listOfProducts.AllAvailableProducts.get(i));
            ProductPanelController productPanelController = new ProductPanelController(productPanel);

            //productPanelControllers.add(productPanelController);
            AllProductPanels.add(productPanel);

        }

    }

    private JPanel createProductPanel(Product product)
    {
        JPanel panel = new JPanel();

        Border raisedetched;
        raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        panel.setBorder(raisedetched);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.HORIZONTAL;

        ProductImage = new JLabel();
        ImageIcon icon = new ImageIcon(new ImageIcon(product.getImagePath()).getImage().getScaledInstance(widthImage, heightImage, Image.SCALE_DEFAULT));
        ProductImage.setIcon(icon);
        ProductName = new JLabel(product.getName());
        ProductPrice = new JLabel(product.getStringPrice());
        ProductDescription = new JLabel(product.getDescription());
        ProductQuantityLeft = new JLabel(product.getStringQuantity());
        ProductQuantityChoosen = new JLabel("QuantityChoosen : 25 ");
        ProductCategory = new JLabel(product.getCategory());



        decreaseQuantity = new JButton("Decrease");
        increaseQuantity = new JButton("Increase");



        c.gridx = 0;
        c.gridy = 0;
        panel.add(ProductImage, c);

        //c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(ProductName, c);

        //c.weightx = 1;
        //c.weighty = 0.1;
        c.gridx = 2;
        c.gridy = 0;
        panel.add(ProductPrice, c);

        c.gridx = 3;
        c.gridy = 0;
        panel.add(ProductCategory, c);

        c.gridx = 4;
        c.gridy = 0;
        panel.add(ProductQuantityChoosen, c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(ProductDescription, c);

        c.ipady = 0;
        c.gridx = 4;
        c.gridy = 1;
        panel.add(increaseQuantity, c);

        c.gridx = 4;
        c.gridy = 2;
        panel.add(decreaseQuantity, c);

        c.ipady = 10;
        c.gridx = 4;
        c.gridy = 3;

        AddToCartFirst = new JButton("AddToCart 1");
        AddToCartSecond = new JButton("AddToCart 2");
        AddToCartButtons = new JButton[]{AddToCartFirst, AddToCartSecond};


        panel.add(AddToCartButtons[chooseRightAddCartButton], c);

        chooseRightAddCartButton++;
        if(chooseRightAddCartButton == AddToCartButtons.length){
            chooseRightAddCartButton = 0;
        }


        //decreaseQuantity = new JButton("Decrease");
        //increaseQuantity = new JButton("Increase");
        //AddToCart = new JButton("Add to cart");





        return panel;
    }

    private  JPanel createTitle(JLabel text) {
        JPanel panel = new JPanel();
        panel.add(text);

        return panel;
    }


    private JPanel createProductBrowseButtonsPanel()
    {
        JPanel panel = new JPanel();

        //add(LayoutHelper.createLargeRigidArea()); to create space between products panel and the choose page buttons panel

        panel.add(PreviousProductPageButton);

        panel.add(LayoutHelper.createRigidArea());

        panel.add(firstPageNumber);
        panel.add(new JLabel("/"));
        panel.add(lastPageNumber);

        panel.add(LayoutHelper.createRigidArea());

        panel.add(NextProductPageButton);

        return panel;
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

    private JPanel createErrorMessagePanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(errorMessage);
        return panel;
    }

    public void displayErrorMessage(String message)
    {
        errorMessage.setText(message);
    }

    public int getPageNumber(){return pageNumber;}
    public void changePageNumber(int num){ pageNumber += num;}
    public int getMaxPageNumber(){return maxPageNumber;}
    public String getFirstPageNumber(){ return firstPageNumber.getText();}
    public void setFirstPageNumber(String newPageNumber){ firstPageNumber.setText(newPageNumber);}
    public int getDebutRangeProduct(){return debutRangeProduct;}
    public void setDebutRangeProduct(int newDebutRangeProduct){  debutRangeProduct = newDebutRangeProduct;}
    public int getEndRangeProduct(){return endRangeProduct;}
    public void setEndRangeProduct(int newEndRangeProduct){ endRangeProduct = newEndRangeProduct;}
    public int getProductPerPage(){return productPerPage;}

    
    public void refreshProductsContainer(){
        productsContainer.removeAll();
        productsContainer.add(createProductContainer());

    }

    private JPanel createButtonsPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 10, 10));

        panel.add(BackMainMenu);
        panel.add(LayoutHelper.createRigidArea());

        panel.add(accesCart);


        return panel;
    }

    private JPanel createFilterPanel(){

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));


        panel.setBorder(LayoutHelper.createLargeEmptyBorder());

        panel.add(new JLabel(""));

        panel.add(activeFilter);

        panel.add(createValueLabel("Name:"));
        panel.add(filterNameTextField);
        panel.add(createValueLabel("Category:"));

        categoryFilter = new JComboBox();
        categoryFilter.setBounds(100,100,100,30);

        panel.add(categoryFilter);


        return panel;

    }




    public void addBackMainListener(ActionListener listener){ BackMainMenu.addActionListener(listener);}
    public void addActiveFilterListener(ActionListener listener){  activeFilter.addActionListener(listener);}
    public void addCartListener(ActionListener listener){accesCart.addActionListener(listener);}
    public void addAddToCartFirstListener(ActionListener listener){AddToCartFirst.addActionListener(listener);}
    public void addAddToCartSecondListener(ActionListener listener){AddToCartSecond.addActionListener(listener);}
    public void addIncreaseQuantityListener(ActionListener listener){increaseQuantity.addActionListener(listener);}
    public void addDecreaseQuantityListener(ActionListener listener){decreaseQuantity.addActionListener(listener);}
    public void addNextPageListener(ActionListener listener)
    {
        NextProductPageButton.addActionListener(listener);
    }
    public void addPreviousPageListener(ActionListener listener){  PreviousProductPageButton.addActionListener(listener);}





}
