package Shop.controllers;

import Shop.formatting.CurrencyHelper;
import Shop.views.CartProductPanel;
import Shop.views.CartView;
import Shop.views.ProductPanel;

import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class CartProductPanelController {

    private final CartProductPanel productPanelView;
    private final CartView mainView;
    private final NumberFormat currencyFormatter;


    public CartProductPanelController(CartProductPanel view, CartView mainView){

        this.productPanelView = view;
        this.mainView = mainView;

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        productPanelView.addRemoveOfCartListener(this::OnRemoveOfCartClicked);
        productPanelView.addIncreaseQuantityListener(this::OnIncreaseQuantityClicked);
        productPanelView.addDecreaseQuantityListener(this::OnDecreaseQuantityClicked);
    }

    private void OnRemoveOfCartClicked(ActionEvent event){
        System.out.println("retirer du panier " + productPanelView.getProductName());
        // tous remove du container, retirer de la db cart l'élement, recréer les panels et refill le container
        mainView.ClearCart();
        // retirer de la db l'élement avec productPanelView.getProductSKU()
        //mainView.getListOfProducts().FillUserCart(); // remplir de nouveau la liste avec la db qui est maintenant actualisé
        mainView.createAllProductInCartPanels(mainView.getListOfProducts());


    }
    private void OnIncreaseQuantityClicked(ActionEvent event) {

        int productQuantityChoosenInt = Integer.parseInt(productPanelView.getProductQuantityChoosen());
        int productQuantityLeftInt = Integer.parseInt(productPanelView.getProductQuantityLeft());

        if(productQuantityChoosenInt < productQuantityLeftInt){
            String quantityChoosenStr = productPanelView.getProductQuantityChoosen();
            int quantityChoosenInt = Integer.parseInt(quantityChoosenStr);
            ++quantityChoosenInt;

            productPanelView.setProductQuantityChoosen(quantityChoosenInt + "");
            productPanelView.displayErrorMessage("");

            // todo augmenter la quantité dnas la bdd

            //todo ensuite set dans le main view les label de prix en récupérant dans la bdd les données


            double subTotal = 0;
            double taxes = 0 ;
            double shippingFee = 0;
            double sotalPrice = 0;

            mainView.setSubTotalLabel(subTotal);
            mainView.setTaxesLabel(taxes);
            mainView.setShippingFeeLabel(shippingFee);
            mainView.setTotalPricelabel(sotalPrice);

            //

        }
        else{
            productPanelView.displayErrorMessage("cannot Increase more !");

        }

    }

    private void OnDecreaseQuantityClicked(ActionEvent event) {

        int productQuantityChoosenInt = Integer.parseInt(productPanelView.getProductQuantityChoosen());

        if(productQuantityChoosenInt > 1){
            int quantityChoosenInt = Integer.parseInt(productPanelView.getProductQuantityChoosen());
            --quantityChoosenInt;

            productPanelView.setProductQuantityChoosen(quantityChoosenInt + "");
            productPanelView.displayErrorMessage("");

            // todo baisser la quantité dnas la bdd

            mainView.setSubTotalLabel(20.00);  //todo ensuite set dans le main view les label de prix en récupérant dans la bdd,1
            mainView.setTaxesLabel(20.00);
            mainView.setShippingFeeLabel(20.00);
            mainView.setTotalPricelabel(20.00);

        }

        else{
            productPanelView.displayErrorMessage("cannot decrease more !");
        }
    }
}
