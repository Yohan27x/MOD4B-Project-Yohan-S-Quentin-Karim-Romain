package Shop.views;

import Shop.formatting.CurrencyHelper;
import Shop.models.Account;
import javax.swing.*;

import Shop.models.IAccountListener;
import Shop.utility.LayoutHelper;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class AccountBalanceView extends JPanel implements IAccountListener {

    private final NumberFormat currencyFormatter;
    private final JLabel nameLabel;
    private final JLabel balanceLabel;
    private final JLabel messageLabel;
    private final JTextField amountTextField;
    private final JButton depositButton;
    private final JButton backMainButton;


    public AccountBalanceView(){

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();
        nameLabel = createValueLabel("");
        balanceLabel = createValueLabel("");
        messageLabel = new JLabel("Enter an amount");
        amountTextField = new JTextField();
        depositButton = new JButton("Deposit");
        backMainButton = new JButton("BackMainPage");


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(createInfoPanel());
        add(LayoutHelper.createRigidArea());
        add(createMessagePanel());
        add(LayoutHelper.createRigidArea());
        add(createAmountPanel());
        add(LayoutHelper.createLargeRigidArea());
        add(createButtonsPanel());
        add(LayoutHelper.createRigidArea());

    }

    private JPanel createInfoPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        panel.add(createTitleLabel("Name:"));
        panel.add(nameLabel);
        panel.add(createTitleLabel("Balance:"));
        panel.add(balanceLabel);

        return panel;
    }

    private static JLabel createTitleLabel(String text)
    {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(JLabel.RIGHT);
        return label;
    }

    private static JLabel createValueLabel(String text)
    {
        JLabel label = new JLabel(text);
        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
        return label;
    }

    private JPanel createMessagePanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(messageLabel);
        return panel;
    }

    private JPanel createAmountPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel("Amount"));
        panel.add(LayoutHelper.createSmallRigidArea());
        panel.add(amountTextField);
        return panel;
    }


    private JPanel createButtonsPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 10));
        panel.add(depositButton);
        panel.add(backMainButton);
        return panel;
    }

    public void initialize(Account account)
    {
        nameLabel.setText(account.getName());
        balanceLabel.setText(currencyFormatter.format(account.getBalance()));
    }

    public void resetAmount()
    {
        amountTextField.setText("");
    }

    public String getAmountText()
    {
        return amountTextField.getText();
    }

    public void displayMessage(String message)
    {
        messageLabel.setText(message);
    }

    public void addDepositListener(ActionListener listener)
    {
        depositButton.addActionListener(listener);
    }

    public void addBacMainListener(ActionListener listener){
        backMainButton.addActionListener(listener);
    }


    @Override
    public void balanceChanged(double balance)
    {
        SwingUtilities.invokeLater(() -> balanceLabel.setText(currencyFormatter.format(balance)));
    }

}
