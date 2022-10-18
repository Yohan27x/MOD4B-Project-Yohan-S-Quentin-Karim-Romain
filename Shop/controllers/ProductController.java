package Shop.controllers;


import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.Random;

import Shop.NavigationService;
import Shop.utility.Window;

import Shop.formatting.CurrencyHelper;
import Shop.models.ListOfProducts;
import Shop.views.ProductView;


public class ProductController {

    private final ListOfProducts listOfProducts = new ListOfProducts();
    private final ProductView view;
    private final Window window;
    private final NumberFormat currencyFormatter;
    
    public ProductController(ProductView view, Window window){
        this.view = view;
        this.window = window;
        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        view.initialize(this.listOfProducts);

        view.addBackMainListener(this::OnBackMainClicked);

        view.addActiveFilterListener(this::OnActiveFilterClicked);

        view.addCartListener(this::OnAccesCartClicked);
        view.addIncreaseQuantityListener(this::OnIncreaseQuantityClicked);
        view.addDecreaseQuantityListener(this::OnDecreaseQuantityClicked);

        view.addNextPageListener(this::OnNextPageClicked);
        view.addPreviousPageListener(this::OnPreviousPageClicked);


    }

    private void OnBackMainClicked(ActionEvent event){
        NavigationService.displayMainPage(window);

    }

    private void OnActiveFilterClicked(ActionEvent event){
        // ...

    }

    private void OnIncreaseQuantityClicked(ActionEvent event){
        // ...


    }

    private void OnDecreaseQuantityClicked(ActionEvent event){
        // ...

    }

    private void OnAccesCartClicked(ActionEvent event){
        NavigationService.displayCartPage(window);

    }



    private void OnNextPageClicked(ActionEvent event){
        view.increasePageNumber();

    }

    private void OnPreviousPageClicked(ActionEvent event){
        view.decreasePageNumber();

    }



}
