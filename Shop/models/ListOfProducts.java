package Shop.models;
import java.sql.*;
import java.util.ArrayList;
import Shop.models.Product;


public class ListOfProducts {
    public ArrayList<Product> AllAvailableProducts = new ArrayList<>();
    final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
    final static String username = "java";
    final static String passwordd = "password";
    
    public ListOfProducts(){

        try (Connection connection = DriverManager.getConnection(url, username, passwordd)){
            String query = "SELECT * FROM shop.product;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){
                //int SKU = Integer.parseInt(resultSet.getString("SKU"));
                System.out.println(Integer.parseInt(resultSet.getString("SKU")));
                AllAvailableProducts.add(new Product(Integer.parseInt(resultSet.getString("SKU")), resultSet.getString("prodName"), Integer.parseInt(resultSet.getString("Price")), resultSet.getString("prodPath"), resultSet.getString("Cartegory"), Integer.parseInt(resultSet.getString("Quantity")), resultSet.getString("prodDescription")));
            }            
            
        } catch (SQLException e) {
            throw new IllegalStateException("ça va être chaud ?", e);
        }
        // retrieve MySQL data ...
        /* 
        Product product1 = new Product("Orange", 5, "https://static.wikia.nocookie.net/minecraft/images/e/e5/AppleOld.png/revision/latest?cb=20200805163025", "food");
        AllAvailableProducts.add(product1);
        Product product2 = new Product("Watermelon", 3, "https://static.wikia.nocookie.net/minecraft/images/2/25/BoneNew.png/revision/latest?cb=20190901164534", "armor");
        AllAvailableProducts.add(product2);
        Product product3 = new Product("Watermelon", 3, "https://static.wikia.nocookie.net/minecraft/images/d/de/CoalNew.png/revision/latest?cb=20190902204730", "food");
        AllAvailableProducts.add(product3);
        Product product4 = new Product("Watermelon", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");
        AllAvailableProducts.add(product4);
        Product product5 = new Product("Watermelon", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");
        AllAvailableProducts.add(product5);
        */


    }



    public void addProduct(){

    }

    public void deleteProduct(){

    }



}
