package Shop.controllers;

import Shop.NavigationService;
import Shop.views.LoginView;
import java.awt.event.ActionEvent;
import Shop.utility.Window;
import Shop.views.RegisterView;
import java.text.NumberFormat;

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
        System.out.println("yes");
        // redirige vers la main page si l'email et le mdp correspondent dans le data base
        NavigationService.displayMainPage(window);
    }

    private void onRegisterClicked(ActionEvent event)
    {
        System.out.println("yes");
        NavigationService.displayRegisterPage(window);
        
    }
}
