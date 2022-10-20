package Shop.models;
import java.sql.*;
import java.util.ArrayList;


public class ListOfProducts {
    public ArrayList<Product> AllAvailableProducts = new ArrayList<>();
    final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
    final static String username = "java";
    final static String passwordd = "password";
    
    public ListOfProducts(){


        // retrieve MySQL data ...



    }

    public void FillUserCart(){
        // ajouter seulememnt les produits qui ont true pour user à la liste
        

    }

    public void fillShopAvailableProduct(){
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

    }

}
