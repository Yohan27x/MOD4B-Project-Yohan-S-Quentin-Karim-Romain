package Shop.controllers;

import Shop.NavigationService;
import Shop.utility.Window;
import Shop.views.CartView;
import Shop.views.PastOrderView;

import java.awt.event.ActionEvent;

public class CartController {

    private final CartView view;
    private final Window window;

    public CartController(CartView view, Window window)
    {

        this.view = view;
        this.window = window;


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
        System.out.println("cart clear");
        //NavigationService.displayMainPage(window);
    }

    private void OnCheckOutClicked(ActionEvent event)
    {
        System.out.println("checkout");
        //NavigationService.displayMainPage(window);
    }


}
