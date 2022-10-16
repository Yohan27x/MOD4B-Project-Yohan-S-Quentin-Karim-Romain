package Shop.models;
import java.util.ArrayList;
import Shop.models.Product;


public class ListOfProducts {
    public ArrayList<Product> AllAvailableProducts = new ArrayList<>();

    public ListOfProducts(){

        // retrieve MySQL data ...

        Product product1 = new Product("Orange", 5, "Shop/Images/JuiceBottle.png");
        Product product2 = new Product("Watermelon", 3, "Shop/Images/watermelon.png");
        Product product3 = new Product("Chocolate", 3,"Shop/Images/chocolate.png" );
        Product product4 = new Product("Strawberry", 7, "Shop/Images/strawberry.png");
        Product product5 = new Product("Strawberry", 7, "Shop/Images/strawberry.png");
        AllAvailableProducts.add(product1);
        AllAvailableProducts.add(product2);
        AllAvailableProducts.add(product3);
        AllAvailableProducts.add(product4);
        AllAvailableProducts.add(product5);

    }



    public void addProduct(){


    }

    public void deleteProduct(){

    }



}
