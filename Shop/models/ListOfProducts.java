package Shop.models;
import java.util.ArrayList;
import Shop.models.Product;


public class ListOfProducts {
    public ArrayList<Product> AllAvailableProducts = new ArrayList<>();

    public ListOfProducts(){

        // retrieve MySQL data ...

        Product product1 = new Product("Orange", 5, "Shop/Images/JuiceBottle.png", "food");
        Product product2 = new Product("Watermelon", 3, "Shop/Images/watermelon.png", "food");
        Product product3 = new Product("Chocolate", 3,"Shop/Images/chocolate.png" , "object");
        Product product4 = new Product("Strawberry", 7, "Shop/Images/strawberry.png", "food");
        Product product5 = new Product("Strawberry", 7, "Shop/Images/strawberry.png", "elec");
        Product product6 = new Product("Strawberry", 7, "Shop/Images/strawberry.png", "elec");
        Product product7 = new Product("Strawberry", 7, "Shop/Images/strawberry.png", "elec");
        AllAvailableProducts.add(product1);
        AllAvailableProducts.add(product2);
        AllAvailableProducts.add(product3);
        AllAvailableProducts.add(product4);
        AllAvailableProducts.add(product5);
        AllAvailableProducts.add(product6);
        AllAvailableProducts.add(product7);

    }



    public void addProduct(){

    }

    public void deleteProduct(){

    }



}
