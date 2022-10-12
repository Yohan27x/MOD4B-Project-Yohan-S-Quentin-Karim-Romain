package Shop;
import javax.security.auth.login.LoginContext;
import javax.swing.*;

import Shop.controllers.LoginController;
import Shop.utility.Window;
import Shop.views.LoginView;
import Shop.views.RegisterView;


public class Program {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(Program::start);
    }

    private static void start()
    {
        useSystemLookAndFeel();
        LoginView Lview = new LoginView();
        LoginController controller = new LoginController(Lview);
        Window window = new Window("APPLICATION", Lview);
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
