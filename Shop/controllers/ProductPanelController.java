package Shop.controllers;

import Shop.views.ProductPanel;

import java.awt.event.ActionEvent;

public class ProductPanelController {

    private final ProductPanel view;

    public ProductPanelController(ProductPanel view){
        this.view = view;

        view.addAddToCartListener(this::OnAddToCartClicked);
        view.addIncreaseQuantityListener(this::OnIncreaseQuantityClicked);
        view.addDecreaseQuantityListener(this::OnDecreaseQuantityClicked);
    }

    private void OnAddToCartClicked(ActionEvent event){
        System.out.println("name : " + view.getProductName());

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
