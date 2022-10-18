package Shop.controllers;

import Shop.NavigationService;
import Shop.models.Account;
import Shop.utility.Window;
import Shop.views.MainView;

import java.awt.event.ActionEvent;

public class MainController {

    private Account account;

    private final MainView view;
    private final Window window;


    public MainController(Account account, MainView view, Window window){
        this.account = account;
        this.view = view;
        this.window = window;

        view.initialize(account);

        //window.getRootPane().setDefaultButton(view.getDefaultButton());
        //view.focusUsername();

        view.addBrowseListener(this::onBrowseClicked);
        view.addStoreBalanceListener(this::onStoreBalanceClicked);
        view.addCartListener(this::onViewCartClicked);
        view.addPastOrdersListener(this::onPastOrderClicked);

    }

    private void onBrowseClicked(ActionEvent event){
        NavigationService.displayProductPage(window);
    }

    private void onStoreBalanceClicked(ActionEvent event){
        NavigationService.displayStoreBalancePage(window);
    }


    private void onViewCartClicked(ActionEvent event){
        NavigationService.displayCartPage(window);
    }

    private void onPastOrderClicked(ActionEvent event){
        NavigationService.displayPastOrdersPage(window);
    }

}
