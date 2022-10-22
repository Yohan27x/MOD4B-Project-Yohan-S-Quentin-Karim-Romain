package Shop.controllers;

import Shop.NavigationService;
import Shop.formatting.CurrencyHelper;
import Shop.repository.connectDb;
import Shop.utility.Window;
import Shop.views.LoginView;
import Shop.views.PastOrderView;

import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PastOrderController {

    private final PastOrderView view;
    private final Window window;

    private final connectDb db;


    private final NumberFormat currencyFormatter;

    private ArrayList<Double> allPricePastOrders;

    public PastOrderController(PastOrderView view, Window window)
    {


        this.db = new connectDb();
        this.view = view;
        this.window = window;

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        // todo ICIII ajouter a la liste les orders de la db correspondant au user true
        
        allPricePastOrders = db.getPastOrder();

        this.view.initialize(allPricePastOrders);


        view.addBackMainListener(this::onBackMainClicked);

    }

    private void onBackMainClicked(ActionEvent event)
    {
        NavigationService.displayMainPage(window);
    }

}
