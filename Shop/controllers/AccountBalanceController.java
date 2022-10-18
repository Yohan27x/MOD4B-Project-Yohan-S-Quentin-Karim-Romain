package Shop.controllers;

import Shop.NavigationService;
import Shop.formatting.CurrencyHelper;
import Shop.models.Account;
import Shop.utility.Window;
import Shop.views.AccountBalanceView;

import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class AccountBalanceController {

    private final Account account;
    private final AccountBalanceView view;
    private final Window window;
    private final NumberFormat currencyFormatter;

    public AccountBalanceController(Account account,AccountBalanceView view, Window window ){
        this.account = account;
        this.view = view;
        this.window = window;
        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        view.initialize(account);
        account.addListener(view);

        view.addDepositListener(this::onDepositClicked);
        view.addBacMainListener(this::onBacMainClicked);

    }

    private void onBacMainClicked(ActionEvent event){
        NavigationService.displayMainPage(window);
    }
    private void onDepositClicked(ActionEvent event)
    {
        try
        {
            String amountText = view.getAmountText();
            double amount = Double.parseDouble(amountText);
            account.deposit(amount);

            double balance = account.getBalance();
            view.displayMessage("Deposited " + currencyFormatter.format(amount));
        }
        catch (NumberFormatException e)
        {
            view.displayMessage("Invalid amount");
            view.resetAmount();
        }
        catch (IllegalArgumentException e)
        {
            view.displayMessage(e.getMessage());
            view.resetAmount();
        }
    }
}
