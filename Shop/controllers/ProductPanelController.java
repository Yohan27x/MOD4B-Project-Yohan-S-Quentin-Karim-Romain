package Shop.controllers;

import Shop.formatting.CurrencyHelper;
import Shop.views.ProductPanel;

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
        int sku = Integer.parseInt(view.getProductSKU());
        String User = "test";
        try (Connection connection = DriverManager.getConnection(url, username, passwordd)){
            String query = "SELECT UserName, logged FROM shop.userdb WHERE logged=true";
            String query2 = "SELECT * FROM shop.product WHERE SKU=?";
            String query3 = "INSERT INTO cart VALUES (?,?,?,?,?,?,?,?,?)";
            Statement statement = connection.createStatement();
            PreparedStatement statement2 = connection.prepareStatement(query2);
            PreparedStatement statement3 = connection.prepareStatement(query3);
            statement2.setInt(1, sku);
            statement3.setInt(1, sku);
            
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                User = resultSet.getString("UserName");
            }
            ResultSet resultSet2 = statement2.executeQuery();
            System.out.println("==============================================================================");
            System.out.println("YES");
            System.out.println("==============================================================================");
            while(resultSet2.next()){
                statement3.setString(4, resultSet2.getString("prodName"));
                statement3.setString(5, resultSet2.getString("prodDescription"));
                statement3.setString(6, "Ma Bite");
                statement3.setString(7, resultSet2.getString("Cartegory"));
                statement3.setDouble(8, resultSet2.getDouble("Price"));
                statement3.setInt(9, resultSet2.getInt("Quantity"));
                statement3.setString(2, User);
                statement3.setBoolean(3,true) ;
            }
            
            int rowsAffected = statement3.executeUpdate();
            if (rowsAffected == 0){
                System.out.println("Can't add the product");
            }
            
        } catch (SQLException e) {
            throw new IllegalStateException("ça va être chaud ?", e);
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
