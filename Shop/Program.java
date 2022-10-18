package Shop;
import java.util.zip.ZipEntry;

import javax.security.auth.login.LoginContext;
import javax.swing.*;


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

        /*


        LoginView loginView = new LoginView();
        Window windowLoginView  = new Window("APPLICATION", loginView);

        RegisterView registerView = new RegisterView();
        Window windowRegisterView  = new Window("APPLICATION", registerView);

        Account account = new Account();
        MainView mainView = new MainView();
        MainController mainController = new MainController(account,mainView);
        Window windowMainView  = new Window("APPLICATION", mainView);

        AccountBalanceView accountBalanceView = new AccountBalanceView();
        Window windowAccountBalanceView = new Window("APPLICATION", accountBalanceView);
        AccountBalanceController accountBalanceController = new AccountBalanceController(account, accountBalanceView);


        ListOfProducts listOfProducts = new ListOfProducts();
        ProductView productView = new ProductView();
        ProductController controller = new ProductController(productView, listOfProducts);
        Window windowProduct = new Window("APPLICATION", productView);

        //windowLoginView.setVisible(true);
        //windowRegisterView.setVisible(true);


        windowProduct.setVisible(true);
        windowAccountBalanceView.setVisible(true);
        windowMainView.setVisible(true);

         */



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
