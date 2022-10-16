package Shop.controllers;


import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.Random;
import Shop.models.ListOfProducts;
import Shop.views.ProductView;


public class ProductController {

    private final ListOfProducts listOfProducts;
    private final ProductView view;
    
    public ProductController(ProductView view, ListOfProducts listOfProducts){
        this.view = view;
        this.listOfProducts = listOfProducts;

        //view.initialize(listOfProducts);
        //listOfProducts.addlisteners;
        view.addNextPageListener(this::OnNextPageClicked);
        view.addPreviousPageListener(this::OnPreviousPageClicked);

    }

    private void OnNextPageClicked(ActionEvent event){
        view.increasePageNumber();

    }

    private void OnPreviousPageClicked(ActionEvent event){
        view.decreasePageNumber();

    }

}
