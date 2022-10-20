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
    private JPanel productsContainer;
    private JLabel firstPageNumber;
    private JLabel lastPageNumber;
    private int pageNumber = 1;
    private int maxPageNumber;
    private int productPerPage = 2;
    private int numOfProducts;
    private JButton NextProductPageButton;
    private JButton PreviousProductPageButton;
    private int debutRangeProduct = 0;
    private int endRangeProduct = 1;
    private ArrayList<JPanel> AllProductPanels = new ArrayList<>();
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

        //this.createAllProductPanels(listOfProducts);
        productsContainer = new JPanel();
        //productsContainer.add(createProductContainer());
        add(productsContainer);

        add(createProductBrowseButtonsPanel());

    }

    public void initialize(ListOfProducts listOfProducts){
        this.productCategory.clear();

        // initialise les différentes catégories de produits
        for (int i = 0; i < listOfProducts.AllAvailableProducts.size(); i++){
            if(!this.productCategory.contains(listOfProducts.AllAvailableProducts.get(i).getCategory())){
                this.productCategory.add(listOfProducts.AllAvailableProducts.get(i).getCategory());
            }
        }

        RefreshNumOfPageAndProduct(listOfProducts);

        this.createAllProductPanels(listOfProducts);
        productsContainer.add(createProductContainer());

        DefaultComboBoxModel<String> modelCategoryBox = new DefaultComboBoxModel<>( productCategory.toArray(new String[0]) );
        categoryFilter.setModel(modelCategoryBox);

    }

    private JPanel createProductContainer(){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));


        for (int i = debutRangeProduct; i <= endRangeProduct; i++) {
            if(i != numOfProducts-1){ // tant qu'on est pas sur le dernier élement
                panel.add(AllProductPanels.get(i));
                panel.add(LayoutHelper.createRigidArea());
            }
            else{
                panel.add(AllProductPanels.get(i));
                panel.add(LayoutHelper.createRigidArea());

                return panel;
            }
        }


        return panel;

    }



    public void createAllProductPanels(ListOfProducts listOfProducts){


        System.out.println("create againt all panels");
        numOfProducts = listOfProducts.AllAvailableProducts.size();

        for (int i = 0; i < listOfProducts.AllAvailableProducts.size(); i++){


            ProductPanel productPanel = new ProductPanel(listOfProducts.AllAvailableProducts.get(i));
            new ProductPanelController(productPanel);

            AllProductPanels.add(productPanel);

        }

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

    
    public void refreshProductsContainer(ListOfProducts listOfProducts){

        RefreshNumOfPageAndProduct(listOfProducts);

        productsContainer.removeAll();

        if(numOfProducts != 0){
            productsContainer.add(createProductContainer());
        }


    }

    private void RefreshNumOfPageAndProduct(ListOfProducts listOfProducts){

        numOfProducts = listOfProducts.AllAvailableProducts.size();
        System.out.println("numOfProducts : " + numOfProducts);

        int numOfAvailableProduct = numOfProducts;
        if(numOfAvailableProduct % 2 == 0){

            maxPageNumber = ((numOfAvailableProduct)/productPerPage);
        }
        else{ // if odd number of available product
            maxPageNumber = ((numOfAvailableProduct)/productPerPage + 1);
        }

        if(numOfProducts == 0){
            maxPageNumber = 1;
        }

        System.out.println("maxPageNumber : " + maxPageNumber);

        lastPageNumber.setText(maxPageNumber + "");

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
    public void addActiveFilterListener(ActionListener listener){ activeFilter.addActionListener(listener);}
    public void addAccesCartListener(ActionListener listener){accesCart.addActionListener(listener);}
    public void addNextPageListener(ActionListener listener)
    {
        NextProductPageButton.addActionListener(listener);
    }
    public void addPreviousPageListener(ActionListener listener){  PreviousProductPageButton.addActionListener(listener);}





}
