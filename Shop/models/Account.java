package Shop.models;

import java.util.ArrayList;

public class Account {

    private String name;
    private String email;
    private String password;
    private String adress;
    private double balance;
    // private past order
    private final ArrayList<IAccountListener> listeners;

    public Account(){
        // MYSQL Data
        this.name = "";
        this.balance = 100.0;
        listeners = new ArrayList<>();

    }
    public void deposit(double amount)
    {
        ensureCanDeposit(amount);
        setBalance(balance + amount);
    }

    private void ensureCanDeposit(double amount)
    {
        if (amount <= 0)
            throw new IllegalArgumentException("Cannot deposit an amount that is not positive.");
    }

    public void setBalance(double balance)
    {
        if (this.balance != balance)
        {
            this.balance = balance;
            for (IAccountListener listener : listeners)
                listener.balanceChanged(balance);
        }
    }

    public void addListener(IAccountListener listener)
    {
        listeners.add(listener);
    }
    public String getName(){
        return name;
    }
    public double getBalance()
    {
        return balance;
    }


}
