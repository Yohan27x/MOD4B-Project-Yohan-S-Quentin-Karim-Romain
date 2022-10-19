package Shop;
import Shop.views.*;
import Shop.controllers.AccountBalanceController;
import Shop.controllers.CartController;
import Shop.controllers.LoginController;
import Shop.controllers.MainController;
import Shop.controllers.PastOrderController;
import Shop.controllers.ProductController;
import Shop.controllers.RegisterController;
import Shop.models.Account;
import Shop.utility.Window;



public final class NavigationService
{
    private NavigationService()
    { }
    
    public static void displayLogInPage(Window window)
    {
        LoginView view = new LoginView();
        window.setContentPane(view);

        LoginController controller = new LoginController(view, window);
    }
    
    public static void displayRegisterPage(Window window)
    {
        RegisterView view = new RegisterView();
        window.setContentPane(view);

        RegisterController controller = new RegisterController(view, window);


        /*
        try
        {
            UserRepository repository = new UserRepository();
            Role[] roles = repository.getRoles().values().toArray(new Role[0]);
            Role defaultRole = repository.getRole(Role.Type.Student);
    
            SignUpView view = new SignUpView(roles, defaultRole);
            window.setContentPane(view);
            
            SignUpController controller = new SignUpController(view, window);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        */

    }
    
    public static void displayMainPage(Window window)
    {
        MainView view = new MainView();
        window.setContentPane(view);
        Account account = new Account(); // todo gérer avec sql

        MainController controller = new MainController(account, view, window);

    }
    
    public static void displayStoreBalancePage(Window window)
    {
        AccountBalanceView view = new AccountBalanceView();
        window.setContentPane(view);
        Account account = new Account(); // todo gérer avec sql

        AccountBalanceController controller = new AccountBalanceController(account, view, window);



    }
    
    public static void displayProductPage(Window window)
    {

        ProductView view = new ProductView();
        window.setContentPane(view);

        ProductController controller = new ProductController(view, window);

        /*
        StudentPortalView view = new StudentPortalView();
        window.setContentPane(view);

         */
    }

    public static void displayPastOrdersPage(Window window)
    {

        PastOrderView view = new PastOrderView();
        window.setContentPane(view);

        PastOrderController controller = new PastOrderController(view, window);

        // Faire controller

        window.setContentPane(view);
    }

    public static void displayCartPage(Window window)
    {

        CartView view = new CartView();
        window.setContentPane(view);

        CartController controller = new CartController(view, window);

        window.setContentPane(view);


    }
}
