package Shop.models;

import javax.swing.text.html.MinimalHTMLWriter;
import java.awt.*;

public class Product {

    private String name;
    private String ImagePath;
    private double price; // canadian dollar
    private int SKU;
    private String category;
    private int quantity;
    private String description;


    public Product(String name, int price, String path){
        this.name = name;
        this.price = price;
        ImagePath = path;
        //ImagePath = "Shop/Images/JuiceBottle.png";

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
