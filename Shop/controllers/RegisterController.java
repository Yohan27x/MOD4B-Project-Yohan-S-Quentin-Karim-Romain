package Shop.controllers;
import Shop.NavigationService;
import Shop.utility.Window;
import Shop.views.RegisterView;
import java.awt.event.ActionEvent;
import java.sql.*;

public class RegisterController {
    private final RegisterView view;
    private final  Window window;
    
    
    public RegisterController(RegisterView view, Window window)
    {   
        this.view = view;
        this.window = window;
        view.addRegisterListener(this::onRegisterClicked);
        view.addBackListener(this::onBackClicked);
        
    }

    private void onRegisterClicked(ActionEvent event)
    {
        try{
            String userName = view.getName();
            String pass = new String(view.getPasswordText());
            String pass2 = new String(view.getConfPasswordText());
            String adress = view.getAdress();
            String mail = view.getMail();
            double balance = Double.parseDouble(view.getBalance());
            //System.out.println("User name :" + userName + "\n PASS : " + pass);
            if (pass.equals(pass2) ){
                testUser(userName, pass, adress, mail, balance, window);
            }else{
                System.out.println("2 password are not the same");
            }
        }catch (NumberFormatException e)
        {
            System.out.println("Invalid amount");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("pas bon");
        }
        
        
    }
    private void onBackClicked(ActionEvent event)
    {
        System.out.println("BACK");
        NavigationService.displayLogInPage(window);

    }

        final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
        final static String username = "java";
        final static String password = "password";
        public static void testUser (String string, String pass, String adress, String mail,double balance, Window window) {
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                String query = "INSERT INTO userdb (UserName, Password,Adress,Email,Balance) VALUES (?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, string);
                statement.setString(2, pass);
                statement.setString(3, adress);
                statement.setString(4, mail);
                statement.setDouble(5, balance);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                NavigationService.displayLogInPage(window);
                
            } catch (SQLException e) {
                throw new IllegalStateException("Cannot connect the database!", e);
            }
        }
      
}




    


