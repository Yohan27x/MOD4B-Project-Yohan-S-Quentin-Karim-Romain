package Shop.controllers;

import Shop.views.LoginView;
import java.awt.event.ActionEvent;
import Shop.utility.Window;
import Shop.views.RegisterView;
import java.text.NumberFormat;

public class LoginController {
    
    private RegisterView registerView = new RegisterView();
    private Window win;
    
    public LoginController(LoginView view)
    {   
        view.addLoginListener(this::onLoginClicked);
        view.addRegisterListener(this::onRegisterClicked);
        
    }

    private void onLoginClicked(ActionEvent event)
    {
        System.out.println("yes");
    }

    private void onRegisterClicked(ActionEvent event)
    {
        System.out.println("yes");
        
    }
}
