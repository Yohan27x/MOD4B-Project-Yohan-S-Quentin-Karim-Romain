package Shop.controllers;

import Shop.NavigationService;
import Shop.models.Account;
import Shop.utility.Window;
import Shop.views.MainView;

import java.awt.event.ActionEvent;
import java.sql.*;

public class MainController {

    private Account account;

    private final MainView view;
    private final Window window;


    public MainController(Account account, MainView view, Window window){
        this.account = account;
        this.view = view;
        this.window = window;

        view.initialize(account);


        view.addBrowseListener(this::onBrowseClicked);
        view.addStoreBalanceListener(this::onStoreBalanceClicked);
        view.addCartListener(this::onViewCartClicked);
        view.addPastOrdersListener(this::onPastOrderClicked);
        view.addLogOutListener(this::onLogOutClicked);
        view.addLogInListener(this::onLogInClicked);
    }

    private void onBrowseClicked(ActionEvent event){
        NavigationService.displayProductPage(window);
    }

    private void onStoreBalanceClicked(ActionEvent event){
        
        if (MainController.logOut() == false) {
            view.displayErrorMessage("You need to be connected to acces your balance !");
        }else{
            NavigationService.displayStoreBalancePage(window);
        }

    }


    private void onViewCartClicked(ActionEvent event){
        if (MainController.logOut() == false) {
            view.displayErrorMessage("You need to be connected to see acces your cart !");
        }else{
            NavigationService.displayCartPage(window);
        }
        // check si connecté
        // view.displayErrorMessage("");
        // else


    }

    private void onPastOrderClicked(ActionEvent event) {
        if (MainController.logOut() == false) {
            view.displayErrorMessage("You need to be connected to see past orders !");
        }else{
            NavigationService.displayPastOrdersPage(window);
        }
    }

    private void onLogOutClicked(ActionEvent event){
        if (logOut()){
            NavigationService.displayLogInPage(window);
        }
    }

    private void onLogInClicked(ActionEvent event){
        if (!logOut()){
            NavigationService.displayLogInPage(window);
        }
    }
    
    final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
        final static String username = "java";
        final static String password = "password";
        public static boolean logOut () {
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                String query = "SELECT UserName FROM userdb WHERE logged= ?";
                String query2 = "UPDATE `shop`.`userdb` SET `logged` = '0' WHERE (`UserName` = ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                PreparedStatement statement2 = connection.prepareStatement(query2);
                statement.setBoolean(1, true);
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    statement2.setString(1, resultSet.getString(1));
                    int rowsAffected = statement2.executeUpdate();
                    if (rowsAffected > 0){
                        return true;
                    }
                }
                return false;
               
                
            } catch (SQLException e) {
                throw new IllegalStateException("Cannot connect the database!", e);
            }
        }
}

