package Shop.models;

import java.sql.*;
import java.util.ArrayList;

public class Account {

    private String name;
    private String email;
    private String password;
    private String adress;
    private double balance;
    // private past order
    private final ArrayList<IAccountListener> listeners;

    final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
    final static String username = "java";
    final static String passwordd = "password";
    public ArrayList<String> nameUser () {
        try (Connection connection = DriverManager.getConnection(url, username, passwordd)){
                ArrayList<String> userData = new ArrayList<String>();
                userData.add("USER");
                userData.add("0");
                String query = "SELECT UserName, Balance FROM userdb WHERE logged=true";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                while(resultSet.next()){
                    userData.set(0,resultSet.getString("UserName"));
                    userData.set(1, resultSet.getString("Balance"));
                }
                
                return userData;
                
                
            } catch (SQLException e) {
                throw new IllegalStateException("Nique ?", e);
            }
        }

    public Account(){
        // MYSQL Data
        
        this.name = nameUser().get(0);
        this.balance = Double.parseDouble(nameUser().get(1));
        listeners = new ArrayList<>();

    }
    public void deposit(double amount)
    {
        ensureCanDeposit(amount);
        setBalance(balance + amount);
    }

    private void ensureCanDeposit(double amount)
    {
        if (amount <= 0)
            throw new IllegalArgumentException("Cannot deposit an amount that is not positive.");
    }

    public void setBalance(double balance)
    {
        try (Connection connection = DriverManager.getConnection(url, username, passwordd)){
            if (this.balance != balance)
        {
            this.balance = balance;
            String query = "SELECT Balance FROM userdb WHERE logged=true";
            String query2 ="UPDATE `shop`.`userdb` SET Balance = ? WHERE (logged=true)";
            PreparedStatement statement2 = connection.prepareStatement(query2);
            statement2.setDouble(1, balance);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int rowsAffected = statement2.executeUpdate();
            }   
            for (IAccountListener listener : listeners)
                listener.balanceChanged(balance);
        }
                   
        } catch (SQLException e) {
            throw new IllegalStateException("Nique ?", e);
        }
    }
        

    public void addListener(IAccountListener listener)
    {
        listeners.add(listener);
    }
    public String getName(){
        return name;
    }
    public double getBalance()
    {
        return balance;
    }


}
