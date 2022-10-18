package Shop.controllers;
import Shop.NavigationService;
import Shop.utility.Window;
import Shop.views.RegisterView;
import java.awt.event.ActionEvent;
import java.sql.*;

public class RegisterController {
    private final RegisterView view;
    private final Window window;
    
    
    public RegisterController(RegisterView view, Window window)
    {   
        this.view = view;
        this.window = window;
        view.addRegisterListener(this::onRegisterClicked);
        view.addBackListener(this::onBackClicked);
        
    }

    private void onRegisterClicked(ActionEvent event)
    {
        String userName = view.getName();
        String pass = new String(view.getPasswordText());
        testUser(userName, pass);
        
    }
    private void onBackClicked(ActionEvent event)
    {
        System.out.println("yes");
        NavigationService.displayLogInPage(window);

    }

        final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
        final static String username = "java";
        final static String password = "password";
        public static void testUser (String string, String pass) {
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("INSERT INTO userdb (UserName, Password,Adress,Email,Balance) VALUES (" + string + "," + pass + ", adress, email, 1000)");
                resultSet.next();
            
                
            } catch (SQLException e) {
                throw new IllegalStateException("Cannot connect the database!", e);
            }
        }
      
}




    


