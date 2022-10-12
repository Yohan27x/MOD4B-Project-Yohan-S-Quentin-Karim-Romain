package Shop;
import java.util.zip.ZipEntry;

import javax.security.auth.login.LoginContext;
import javax.swing.*;


import Shop.controllers.ProductController;
import Shop.models.ListOfProducts;
import Shop.utility.Window;
import Shop.views.LoginView;
import Shop.views.ProductView;
import Shop.views.RegisterView;;


public class Program {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(Program::start);
    }

    private static void start()
    {
        useSystemLookAndFeel();


        LoginView loginView = new LoginView();
        Window windowLoginView  = new Window("APPLICATION", loginView);

        ListOfProducts listOfProducts = new ListOfProducts();
        ProductView productview = new ProductView();

        RegisterView registerView = new RegisterView();
        Window windowRegisterView = new Window("APPLICATION", registerView);

        ProductController controller = new ProductController(productview, listOfProducts);

        Window windowProduct = new Window("APPLICATION", productview);
        windowRegisterView.setVisible(true);
        windowLoginView.setVisible(true);
        windowProduct.setVisible(true);


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
