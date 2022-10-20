package Shop.controllers;

import Shop.NavigationService;
import Shop.formatting.CurrencyHelper;
import Shop.models.ListOfProducts;
import Shop.utility.Window;
import Shop.views.CartView;
import Shop.views.PastOrderView;

import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class CartController {

    private final ListOfProducts listOfProducts = new ListOfProducts();
    private final CartView view;
    private final Window window;

    private final NumberFormat currencyFormatter;


    public CartController(CartView view, Window window)
    {

        this.view = view;
        this.window = window;

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        //listOfProducts.FillUserCart();
        view.initialize(this.listOfProducts);

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

        // clear le cart dans la db et dans le view view.ClearCart();
        System.out.println("cart clear");
        view.ClearCart();

    }

    private void OnCheckOutClicked(ActionEvent event)
    {

        // checker si assez d'argent avec database et mettre message si c'est pas le cas
        // si ok soustraire total price au balance et update dans la database
        // dans la db, update la quantité restante du produit en soustractant la quantité choisis par l'user
        // dans la db, update la quantitysolded du produit en additionnant la quantité choisis par l'user
        // supprimer les produits du panier dnas la db et dans le view //view.ClearCart();


        view.createAllProductInCartPanels(listOfProducts);

        view.displayErrorMessage(true, "ok checkout!"); // bleue ok
        //view.displayErrorMessage(false, "probleme !"); // rouge erreur
    }


}
