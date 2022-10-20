package Shop.controllers;

import Shop.NavigationService;
import Shop.formatting.CurrencyHelper;
import Shop.utility.Window;
import Shop.views.LoginView;
import Shop.views.PastOrderView;

import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PastOrderController {

    private final PastOrderView view;
    private final Window window;

    private final NumberFormat currencyFormatter;

    private ArrayList<Double> allPricePastOrders = new ArrayList<>();

    public PastOrderController(PastOrderView view, Window window)
    {

        // ajouter les prix des orders du true account avec sql
        allPricePastOrders.add(10.00);
        allPricePastOrders.add(20.00);
        allPricePastOrders.add(30.00);

        this.view = view;
        this.window = window;

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        this.view.initialize(allPricePastOrders);

        //window.getRootPane().setDefaultButton(view.getDefaultButton());
        //view.focusUsername();

        view.addBackMainListener(this::onBackMainClicked);

    }

    private void onBackMainClicked(ActionEvent event)
    {
        NavigationService.displayMainPage(window);
    }

}
