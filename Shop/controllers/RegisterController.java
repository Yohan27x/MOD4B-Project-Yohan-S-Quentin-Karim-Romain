package Shop.controllers;

import Shop.NavigationService;
import Shop.utility.Window;
import Shop.views.LoginView;
import Shop.views.RegisterView;

import java.awt.event.ActionEvent;

public class RegisterController {

    private final RegisterView view;
    private final Window window;

    public RegisterController(RegisterView view, Window window)
    {

        this.view = view;
        this.window = window;

        //window.getRootPane().setDefaultButton(view.getDefaultButton());
        //view.focusUsername();

        view.addBackListener(this::onBackClicked);

    }

    private void onBackClicked(ActionEvent event)
    {
        System.out.println("yes");
        NavigationService.displayLogInPage(window);

    }

}
