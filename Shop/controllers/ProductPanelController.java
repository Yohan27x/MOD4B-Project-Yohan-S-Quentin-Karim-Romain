package Shop.controllers;

import Shop.formatting.CurrencyHelper;
import Shop.views.ProductPanel;
import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;
import java.lang.Thread.State;
import java.sql.*;
import java.text.NumberFormat;

public class ProductPanelController {

    private final ProductPanel view;

    private final NumberFormat currencyFormatter;

    final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
    final static String username = "java";
    final static String passwordd = "password";


    public ProductPanelController(ProductPanel view){
        this.view = view;

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        view.addAddToCartListener(this::OnAddToCartClicked);
        view.addIncreaseQuantityListener(this::OnIncreaseQuantityClicked);
        view.addDecreaseQuantityListener(this::OnDecreaseQuantityClicked);
    }

    private void OnAddToCartClicked(ActionEvent event){

        if(MainController.logOut() == false){
            view.displayErrorMessage("You must be connected to add " +
                    "product to your cart !");
        }
        else {
        int sku = Integer.parseInt(view.getProductSKU());
        String User = "test";
        int SKU = 0;
        
        int quant = Integer.parseInt(view.getProductQuantityChoosen());
        System.out.println("====== : " + sku);
        try (Connection connection = DriverManager.getConnection(url, username, passwordd)){
            String query = "SELECT UserName, logged FROM shop.userdb WHERE logged=true";
            String query2 = "SELECT * FROM shop.product WHERE SKU=?";
            String query3 = "INSERT INTO cart VALUES (?,?,?,?,?,?,?,?,?)";
            String queryT = "SELECT * FROM shop.cart";
            Statement statement = connection.createStatement();
            Statement statementT = connection.createStatement();
            PreparedStatement statement2 = connection.prepareStatement(query2);
            PreparedStatement statement3 = connection.prepareStatement(query3);
            statement2.setInt(1, sku);
            // incrémenter le SKU
            ResultSet increm = statementT.executeQuery(queryT);
            while (increm.next()) {
                SKU++;
                System.out.println(SKU);
            }
            statement3.setInt(1, SKU+1);
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                User = resultSet.getString("UserName");
                System.out.println(User);

            }
            System.out.println("?????????????????????????????????????????");
            ResultSet resultSet2 = statement2.executeQuery();
            System.out.println("??????????????????!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!???????????????????????");
            while(resultSet2.next()){
                System.out.println(User);
                statement3.setString(2, User);
                statement3.setString(3, resultSet2.getString("prodName"));
                statement3.setString(4, resultSet2.getString("prodDescription"));
                statement3.setString(5, resultSet2.getString("prodPath"));
                statement3.setString(6, resultSet2.getString("Cartegory"));
                statement3.setDouble(7, resultSet2.getDouble("Price"));
                statement3.setInt(8,  resultSet2.getInt("Quantity"));
                statement3.setInt(9, quant);
            }
        }
    }


    private void OnIncreaseQuantityClicked(ActionEvent event) {

        int productQuantityChoosenInt = Integer.parseInt(view.getProductQuantityChoosen());
        int productQuantityLeftInt = Integer.parseInt(view.getProductQuantityLeft());

        if(productQuantityChoosenInt < productQuantityLeftInt){
            String quantityChoosenStr = view.getProductQuantityChoosen();
            int quantityChoosenInt = Integer.parseInt(quantityChoosenStr);
            ++quantityChoosenInt;

            view.setProductQuantityChoosen(quantityChoosenInt + "");
            view.displayErrorMessage("");

        }
        else{
           view.displayErrorMessage("cannot Increase more !");

        }

    }

    private void OnDecreaseQuantityClicked(ActionEvent event) {

        int productQuantityChoosenInt = Integer.parseInt(view.getProductQuantityChoosen());

        if(productQuantityChoosenInt > 1){
            int quantityChoosenInt = Integer.parseInt(view.getProductQuantityChoosen());
            --quantityChoosenInt;

            view.setProductQuantityChoosen(quantityChoosenInt + "");
            view.displayErrorMessage("");

        }

        else{
            view.displayErrorMessage("cannot decrease more !");
        }
    }

}
