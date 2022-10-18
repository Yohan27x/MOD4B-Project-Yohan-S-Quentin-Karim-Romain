package Shop.controllers;

import Shop.views.LoginView;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LoginController {
    private final LoginView view;
    
    
    public LoginController(LoginView view)
    {   
        this.view = view;
        view.addLoginListener(this::onLoginClicked);
        view.addRegisterListener(this::onRegisterClicked);
        
    }

    private void onLoginClicked(ActionEvent event)
    {
        String userName = view.getLoginText();
        String pass = new String(view.getPasswordText());
        testUser(userName, pass);
    }

    private void onRegisterClicked(ActionEvent event)
    {
        System.out.println("yes");
        
    }

        final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
        final static String username = "java";
        final static String password = "password";
        public static void testUser (String string, String pass) {
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                int yes = 0;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT UserName,Password FROM userdb WHERE UserName='"+ string +"' AND Password='"+ pass+ "'");
                while(resultSet.next()){
                    yes++;
                    System.out.println("================================================================================================================");
                    System.out.println(resultSet.getString("UserName"));
                    System.out.println(resultSet.getString("Password"));
                    System.out.println("================================================================================================================");
                }

                if (yes==0){
                    System.out.println("User not recognized");
                }
                
            } catch (SQLException e) {
                throw new IllegalStateException("Cannot connect the database!", e);
            }
        }
}
