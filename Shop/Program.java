package Shop;
import java.sql.*;
import java.util.zip.ZipEntry;

import javax.security.auth.login.LoginContext;
import javax.swing.*;

import Shop.controllers.LoginController;
import Shop.controllers.ProductController;
import Shop.controllers.RegisterController;
import Shop.controllers.AccountBalanceController;
import Shop.controllers.MainController;
import Shop.controllers.ProductController;
import Shop.models.Account;
import Shop.models.ListOfProducts;
import Shop.utility.Window;
import Shop.views.LoginView;
import Shop.views.ProductView;

import Shop.views.RegisterView;



public class Program {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(Program::start);
    }

    private static void start()
    {
        useSystemLookAndFeel();

        Window window = new Window("LoginPage", true);
        NavigationService.displayLogInPage(window);
        window.setVisible(true);

       
        
        


    }

    private static void useSystemLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    
}
