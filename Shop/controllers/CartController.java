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

        //window.getRootPane().setDefaultButton(view.getDefaultButton());
        //view.focusUsername();

        view.addBackMainListener(this::onBackMainClicked);

    }

    private void onBackMainClicked(ActionEvent event)
    {
        NavigationService.displayMainPage(window);
    }


}
