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
    private int soldedQuantity;

    public Product(String name, double price, String path, String category){
        this.name = name;
        this.price = price;
        this.quantity = 10;
        this.category = category;
        this.description = "A very simple product!";
        this.imagePath = path;

    }
    public Product(String name, double price, int quantity, String path, String category, String description, int SKU, int soldedQuantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = path;
        this.category = category;
        this.description = description;
        this.SKU = SKU;
        this.soldedQuantity = soldedQuantity;

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



}
