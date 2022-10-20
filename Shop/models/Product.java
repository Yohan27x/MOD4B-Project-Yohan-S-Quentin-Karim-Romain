package Shop.models;

import javax.swing.text.html.MinimalHTMLWriter;
import java.awt.*;

public class Product {

    private String name;
    private double price; // canadian dollar
    private int quantity;
    private String category;
    private String description;
    private String ImagePath;
    private int SKU;

    private boolean inStock;

    private int soldedQuantity;

    public Product(int SKU, String name, int price, String path, String category, int quantity, String description){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
        this.SKU = SKU;

        ImagePath = path;


    }
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String getStringPrice(){
        return price+"$";
    }
    public String getImagePath(){
        return ImagePath;
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



}
