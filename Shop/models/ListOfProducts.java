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
        if (AllAvailableProducts.size()>= 1){
            AllAvailableProducts.clear();
        }
        // ajouter seulememnt les produits qui ont true pour user à la liste
        try (Connection connection = DriverManager.getConnection(url, username, passwordd)){
            String user = "";
            String query = "SELECT UserName FROM shop.userdb WHERE logged=true;";
            String query2 = "SELECT * FROM shop.cart WHERE UserName=?;";
            Statement statement = connection.createStatement();
            PreparedStatement statement2 = connection.prepareStatement(query2);
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                user = resultSet.getString("UserName");
                statement2.setString(1, user);
            }
            ResultSet resultSet2 = statement2.executeQuery();
            while (resultSet2.next()) {
                AllAvailableProducts.add(new Product(Integer.parseInt(resultSet2.getString("SKU")), resultSet2.getString("prodName"), Double.parseDouble(resultSet2.getString("Price")), resultSet2.getString("prodPath"), resultSet2.getString("Cartegory"), Integer.parseInt(resultSet2.getString("Quantity")), resultSet2.getString("prodDescription"), resultSet2.getInt("QuantityChosen")));
            }


        } catch (SQLException e) {
            throw new IllegalStateException("nique", e);
        }

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
            throw new IllegalStateException("ça va être chaud ????", e);
        }

    }

}
