package Shop.controllers;

import Shop.NavigationService;
import Shop.formatting.CurrencyHelper;
import Shop.models.ListOfProducts;
import Shop.repository.connectDb;
import Shop.utility.Window;
import Shop.views.CartView;
import Shop.views.PastOrderView;

import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class CartController {

    private final ListOfProducts listOfProducts;
    private final CartView view;
    private final Window window;
    private final NumberFormat currencyFormatter;
    private final connectDb db;


    public CartController(CartView view, Window window)
    {

        this.db = new connectDb();
        this.view = view;
        this.window = window;

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();
        listOfProducts = new ListOfProducts();
        listOfProducts.FillUserCart(); // todo remplacer par filluserCart
        view.initialize(this.listOfProducts);

        view.setSubTotalLabel(db.getSubtotal());
        view.setTaxesLabel(db.getTaxtotal());
        view.setShippingFeeLabel(db.getShipping());
        view.setTotalPricelabel(db.getTotal());


        view.addBackMainListener(this::onBackMainClicked);
        view.addClearCartListener(this::OnClearCartClicked);
        view.addCheckOutListener(this::OnCheckOutClicked);

    }

    
    private void onBackMainClicked(ActionEvent event)
    {
        NavigationService.displayMainPage(window);
    }

    private void OnClearCartClicked(ActionEvent event)
    {

        db.clearCart();
        view.ClearCart();

        // todo remove product cart in the dataBase

    }

    private void OnCheckOutClicked(ActionEvent event)
    {

        System.out.println("Check out ! ");
        if(!db.checkBalance()){
            System.out.println("no money");
        }
        else{
            db.updateBalanceAfterCheckout();
        }

        // checker si assez d'argent avec database et mettre message si c'est pas le cas
        // si ok soustraire total price au balance et update dans la database
        // dans la db, update la quantité restante du produit en soustractant la quantité choisis par l'user
        // dans la db, update la quantitysolded du produit en additionnant la quantité choisis par l'user
        db.clearCart();
        view.ClearCart();


        //view.displayErrorMessage(true, "ok checkout!"); // bleue ok
        //view.displayErrorMessage(false, "probleme !"); // rouge erreur
    }


}
