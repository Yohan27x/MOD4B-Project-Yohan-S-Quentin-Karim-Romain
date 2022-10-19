package Shop.controllers;


import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.Random;

import Shop.utility.Window;
import Shop.NavigationService;
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

        view.addNextPageListener(this::OnNextPageClicked);
        view.addPreviousPageListener(this::OnPreviousPageClicked);


    }

    private void OnBackMainClicked(ActionEvent event){NavigationService.displayMainPage(window);}

    private void OnAccesCartClicked(ActionEvent event){NavigationService.displayCartPage(window);
    }

    private void OnActiveFilterClicked(ActionEvent event){

        view.setFirstPageNumber("1");

        listOfProducts.AllAvailableProducts.remove(0);

        view.refreshProductsContainer(listOfProducts);
        view.createAllProductPanels(listOfProducts);

    }

    private void OnNextPageClicked(ActionEvent event){
        if(view.getPageNumber() < view.getMaxPageNumber()){
            int newFirstPageNumber = view.getPageNumber();
            newFirstPageNumber += 1;
            view.changePageNumber(1);
            view.setFirstPageNumber(newFirstPageNumber + "") ;

            int newDebutRangeProduct = view.getDebutRangeProduct() + view.getProductPerPage();
            view.setDebutRangeProduct(newDebutRangeProduct);

            int newEndRangeProduct = view.getEndRangeProduct() + view.getProductPerPage();
            view.setEndRangeProduct(newEndRangeProduct);

            System.out.println(view.getFirstPageNumber());

            view.refreshProductsContainer(listOfProducts);

            view.displayErrorMessage(""); // erase an possible error message that happened before

        }
        else{
            view.displayErrorMessage("You are at the last page, there are no more products to see");
        }


    }

    private void OnPreviousPageClicked(ActionEvent event){
        if(view.getPageNumber() > 1){
            int newFirstPageNumber = view.getPageNumber();
            newFirstPageNumber -= 1;
            view.changePageNumber(-1);
            view.setFirstPageNumber(newFirstPageNumber + "");


            int newDebutRangeProduct = view.getDebutRangeProduct() - 2;
            view.setDebutRangeProduct(newDebutRangeProduct);

            int newEndRangeProduct = view.getEndRangeProduct() - 2;
            view.setEndRangeProduct(newEndRangeProduct);

            System.out.println(view.getFirstPageNumber());

            view.refreshProductsContainer(listOfProducts);

            view.displayErrorMessage(""); // erase an possible error message that happened before



        }
        else{
            view.displayErrorMessage("You are on the first page, you cannot go any page further back!");
        }





    }



}
