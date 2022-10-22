package Shop.controllers;

import Shop.formatting.CurrencyHelper;
import Shop.repository.connectDb;
import Shop.views.ProductPanel;
import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;
import java.lang.Thread.State;
import java.sql.*;
import java.text.NumberFormat;

public class ProductPanelController {

    private final ProductPanel view;

    private final NumberFormat currencyFormatter;

    private final connectDb db;


    public ProductPanelController(ProductPanel view){
        this.view = view;
        this.db = new connectDb();

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        view.addAddToCartListener(this::OnAddToCartClicked);
        view.addIncreaseQuantityListener(this::OnIncreaseQuantityClicked);
        view.addDecreaseQuantityListener(this::OnDecreaseQuantityClicked);
    }

    private void OnAddToCartClicked(ActionEvent event){
        if(db.isLogged()){
            db.addToCart(Integer.parseInt(view.getProductSKU()),Integer.parseInt(view.getProductQuantityChoosen()) );
        }
        else{
            view.displayErrorMessage(" you have to be log");
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
