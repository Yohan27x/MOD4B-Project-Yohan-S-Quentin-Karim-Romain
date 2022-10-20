package Shop.controllers;

import Shop.formatting.CurrencyHelper;
import Shop.views.ProductPanel;

import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class ProductPanelController {

    private final ProductPanel view;

    private final NumberFormat currencyFormatter;


    public ProductPanelController(ProductPanel view){
        this.view = view;

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        view.addAddToCartListener(this::OnAddToCartClicked);
        view.addIncreaseQuantityListener(this::OnIncreaseQuantityClicked);
        view.addDecreaseQuantityListener(this::OnDecreaseQuantityClicked);
    }

    private void OnAddToCartClicked(ActionEvent event){

        // donner ce sku a la db qui trouve le produit et l'ajoute au cart
        int sku = Integer.parseInt(view.getProductSKU());

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
