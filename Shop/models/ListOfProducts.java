package Shop.models;
import java.sql.*;
import java.util.ArrayList;


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
                System.out.println(Integer.parseInt(resultSet.getString("SKU")));
                AllAvailableProducts.add(new Product(Integer.parseInt(resultSet.getString("SKU")), resultSet.getString("prodName"), Double.parseDouble(resultSet.getString("Price")), resultSet.getString("prodPath"), resultSet.getString("Cartegory"), Integer.parseInt(resultSet.getString("Quantity")), resultSet.getString("prodDescription")));
            }            
            
        } catch (SQLException e) {
            throw new IllegalStateException("ça va être chaud ?", e);
        }
        // retrieve MySQL data ...
        /* 
        Product product1 = new Product("Orange", 5, "https://static.wikia.nocookie.net/minecraft/images/e/e5/AppleOld.png/revision/latest?cb=20200805163025", "food");

    }

    public void FillUserCart(){
        // ajouter seulememnt les produits qui ont true pour user à la liste
        Product product1 = new Product("Apple", 5, "https://static.wikia.nocookie.net/minecraft/images/e/e5/AppleOld.png/revision/latest?cb=20200805163025", "food");
        AllAvailableProducts.add(product1);
        Product product2 = new Product("Bone", 3, "https://static.wikia.nocookie.net/minecraft/images/2/25/BoneNew.png/revision/latest?cb=20190901164534", "armor");
        AllAvailableProducts.add(product2);
        Product product3 = new Product("Coal", 3, "https://static.wikia.nocookie.net/minecraft/images/d/de/CoalNew.png/revision/latest?cb=20190902204730", "food");
        AllAvailableProducts.add(product3);
        Product product4 = new Product("Diamond", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");
        AllAvailableProducts.add(product4);

        Product product5 = new Product("Watermelon", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");
        AllAvailableProducts.add(product5);
        



        Product product5 = new Product("Diamond", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");>>>>>>> 01f6b15604de79b1d342dba6f56ded5f7d6c4fd2
    }

    public void FillShopAvailableProduct(){
        Product product1 = new Product("Apple", 5, "https://static.wikia.nocookie.net/minecraft/images/e/e5/AppleOld.png/revision/latest?cb=20200805163025", "food");
        AllAvailableProducts.add(product1);
        Product product2 = new Product("Bone", 3, "https://static.wikia.nocookie.net/minecraft/images/2/25/BoneNew.png/revision/latest?cb=20190901164534", "armor");
        AllAvailableProducts.add(product2);
        Product product3 = new Product("Coal", 3, "https://static.wikia.nocookie.net/minecraft/images/d/de/CoalNew.png/revision/latest?cb=20190902204730", "food");
        AllAvailableProducts.add(product3);
        Product product4 = new Product("Diamond", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");
        AllAvailableProducts.add(product4);
        Product product5 = new Product("Diamond", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");
        */
    }

}
