package Shop.controllers;

import Shop.NavigationService;
import Shop.utility.Window;
import Shop.views.LoginView;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LoginController {
    private final LoginView view;
    
    private final Window window;
    
    public LoginController(LoginView view, Window window)
    {

        this.view = view;
        this.window = window;

        //window.getRootPane().setDefaultButton(view.getDefaultButton());
        //view.focusUsername();

        view.addLoginListener(this::onLoginClicked);
        view.addRegisterListener(this::onRegisterClicked);
        
    }

    private void onLoginClicked(ActionEvent event)
    {

        String userName = view.getLoginText();
        String pass = new String(view.getPasswordText());
        if (testUser(userName, pass)){
            NavigationService.displayMainPage(window);
        }

    }

    private void onRegisterClicked(ActionEvent event)
    {
        NavigationService.displayRegisterPage(window);
        
    }

        final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
        final static String username = "java";
        final static String password = "password";
        public static boolean testUser (String string, String pass) {
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                String query = "SELECT UserName,Password FROM userdb WHERE UserName= ? AND Password= ?";
                String query2 = "UPDATE `shop`.`userdb` SET `logged` = '1' WHERE (`UserName` = ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                PreparedStatement statement2 = connection.prepareStatement(query2);
                statement.setString(1, string);
                statement.setString(2, pass);
                statement2.setString(1, string);
                ResultSet resultSet = statement.executeQuery();
                int rowsAffected = statement2.executeUpdate();
                while(resultSet.next()){
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

