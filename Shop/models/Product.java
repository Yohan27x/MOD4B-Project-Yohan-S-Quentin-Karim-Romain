package Shop.models;

import javax.swing.text.html.MinimalHTMLWriter;
import java.awt.*;

public class Product {

    private String name;
    private double price; // canadian dollar
    private int quantity;
    private String category;
    private String description;
    private String imagePath;
    private int SKU;
    private int quantityChoosen = 1;

    public Product(int SKU, String name, double price, String path, String category, int quantity, String description){

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
        this.SKU = SKU;

        //ImagePath = path;

        this.description = "A very simple product!";
        this.imagePath = path;

    }
    public Product( String name, double price, String path, String category, int quantity, String description, int quantityChoosen) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = path;
        this.category = category;
        this.description = description;
        this.quantityChoosen = quantityChoosen;

    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String getStringPrice(){
        return price+"";
    }
    public String getImagePath(){
        return imagePath;
    }

    public String getDescription(){
        return description;
    }

    public String getStringSku(){
        return SKU+"";
    }

    public String getStringQuantity(){
        return quantity+"";
    }

    public String getCategory(){
        return category;
    }

    public String getStringQuantityChoosen(){
        return quantityChoosen + "";
    }

}
