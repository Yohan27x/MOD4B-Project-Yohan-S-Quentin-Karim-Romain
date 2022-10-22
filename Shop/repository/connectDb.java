package Shop.repository;

import java.sql.*;
import java.util.ArrayList;

public class connectDb {
    final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
    final static String username = "java";
    final static String password = "password";
    
    public connectDb(){
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connected");

        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect to the database", e);
        }
    }

    public static boolean isLogged () {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String query = "SELECT * FROM userdb WHERE logged= true";
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                return true;
            }
            return false;
           
            
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public void addToCart(int sku, int quantity){
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String User = "test";
                String query = "SELECT UserName, logged FROM shop.userdb WHERE logged=true";
                String query2 = "SELECT * FROM shop.product WHERE SKU=?";
                String query3 = "INSERT INTO cart VALUES (?,?,?,?,?,?,?,?)";
                Statement statement = connection.createStatement();
                PreparedStatement statement2 = connection.prepareStatement(query2);
                PreparedStatement statement3 = connection.prepareStatement(query3);
                
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    User = resultSet.getString("UserName");
                    System.out.println(User);
    
                }
                statement2.setInt(1, sku);
                ResultSet resultSet2 = statement2.executeQuery();
                while(resultSet2.next()){
                    System.out.println(User);
                    statement3.setString(1, User);
                    statement3.setString(2, resultSet2.getString("prodName"));
                    statement3.setString(3, resultSet2.getString("prodDescription"));
                    statement3.setString(4, resultSet2.getString("prodPath"));
                    statement3.setString(5, resultSet2.getString("Cartegory"));
                    statement3.setDouble(6, resultSet2.getDouble("Price"));
                    statement3.setInt(7,  resultSet2.getInt("Quantity"));
                    statement3.setInt(8, quantity);
                }
                int rowsAffected = statement3.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("Can't add the product");
                }
    
            } catch (SQLException e) {
                throw new IllegalStateException("failed to add quantity", e);
            }
    }

    public double getSubtotal(){
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String User = "test";
            double price = 0;
                String query = "SELECT UserName, logged FROM shop.userdb WHERE logged=true";
                String query2 = "SELECT * FROM shop.cart WHERE UserName=?";
                Statement statement = connection.createStatement();
                PreparedStatement statement2 = connection.prepareStatement(query2);
                
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    User = resultSet.getString("UserName");
                    System.out.println(User);
    
                }
                statement2.setString(1, User);
                ResultSet resultSet2 = statement2.executeQuery();
                while(resultSet2.next()){
                   double temp = resultSet2.getInt("QuantityChosen") * resultSet2.getDouble("Price");
                   price += temp;
                }
                return price;
    
            } catch (SQLException e) {
                throw new IllegalStateException("failed to add quantity", e);
            }
    }

    public double getTaxtotal(){
            double subTotal = getSubtotal();
            double taxeGST = subTotal*0.05;
            double taxeQST = subTotal*0.0975;
            return taxeGST + taxeQST;
    }

    public double getShipping(){
        double shippingFee = 9.99;
        if (getSubtotal()+getTaxtotal() > 35){
            shippingFee = 0;
        }
        return shippingFee;
    }

    public double getTotal(){
        return getShipping()+ getSubtotal() + getTaxtotal();
    }

    public boolean checkBalance(){
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String User = "test";
            double balance = 0;
                String query = "SELECT Balance FROM shop.userdb WHERE logged=true";
                Statement statement = connection.createStatement();
                
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    balance = resultSet.getDouble("Balance");
    
                }

                return getTotal() < balance;
                
    
            } catch (SQLException e) {
                throw new IllegalStateException("failed to add quantity", e);
            }
    }

    public void updateBalanceAfterCheckout(){
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String User = "test";
            double balance = 0;
            double price = getTotal();
            String queryU = "SELECT UserName, logged FROM shop.userdb WHERE logged=true";
                String query = "SELECT Balance FROM shop.userdb WHERE logged=true";
                String query2 = "UPDATE userdb SET Balance = ? WHERE UserName = ?";
                String query3 = "INSERT INTO ordershop VALUES (?, ?)";
                Statement statement = connection.createStatement();
                Statement statementU = connection.createStatement();
                PreparedStatement statement2 = connection.prepareStatement(query2);
                PreparedStatement statement3 = connection.prepareStatement(query3);
                ResultSet resultName = statementU.executeQuery(queryU);
                while(resultName.next()){
                    User = resultName.getString("UserName");
                    System.out.println(User);
    
                }
                
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    balance = resultSet.getDouble("Balance");
                }
                balance -= price;
                statement2.setDouble(1, balance);
                statement2.setString(2, User);
                
                int rowsUpdated = statement2.executeUpdate();
                if (rowsUpdated == 0) {
                    System.out.println("Balance not updated");
                }

                statement3.setString(1, User);
                statement3.setDouble(2, price);
                int rowsAffected = statement3.executeUpdate();
                if (rowsAffected == 0){
                    System.out.println("Order didn't printed");
                }
    
            } catch (SQLException e) {
                throw new IllegalStateException("failed to buy", e);
            }
    }

    public void clearCart(){
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String User = "";
            String queryU = "SELECT UserName, logged FROM shop.userdb WHERE logged=true";
                String query2 = "DELETE FROM cart WHERE UserName = ?;";
                Statement statementU = connection.createStatement();
                PreparedStatement statement2 = connection.prepareStatement(query2);
                
                ResultSet resultName = statementU.executeQuery(queryU);
                while(resultName.next()){
                    User = resultName.getString("UserName");
                    System.out.println(User);
    
                }
            
                statement2.setString(1, User);
                
                int rowsAffected = statement2.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("Cart not updated");
                }
    
            } catch (SQLException e) {
                throw new IllegalStateException("failed to buy", e);
            }
    }

    public ArrayList<Double> getPastOrder(){
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String User = "";
            ArrayList<Double> priceOrder = new ArrayList<>();
            String queryU = "SELECT UserName, logged FROM shop.userdb WHERE logged=true";
                String query2 = "SELECT price FROM shop.ordershop WHERE userName=?;";
                Statement statementU = connection.createStatement();
                PreparedStatement statement2 = connection.prepareStatement(query2);
                
                ResultSet resultName = statementU.executeQuery(queryU);
                while(resultName.next()){
                    User = resultName.getString("UserName");
                    System.out.println(User);
                }
                statement2.setString(1, User);
                ResultSet resultSet = statement2.executeQuery();
                while(resultSet.next()){
                    priceOrder.add(resultSet.getDouble("price"));
                }
                return priceOrder;
    
            } catch (SQLException e) {
                throw new IllegalStateException("failed to do order", e);
            }

            
    }

}
