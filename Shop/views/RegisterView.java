package Shop.views;
import javax.swing.*;
import Shop.utility.LayoutHelper;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView extends JPanel{

    private JLabel appName;
    private JTextField userTextField;
    private JTextField adresTextField;
    private JTextField mailAdressField;
    private JTextField accountBalanceField;
    private JPasswordField passwordTextField;
    private JPasswordField passwordTextField2;
    private JButton backButton;
    private JButton registerButton;


    public RegisterView(){
        appName = new JLabel("Register Page");
        userTextField = new JTextField();
        adresTextField = new JTextField();
        mailAdressField = new JTextField();
        accountBalanceField = new JTextField();
        passwordTextField = new JPasswordField();
        passwordTextField2 = new JPasswordField();
        backButton = new JButton("   Back   ");
        registerButton = new JButton("   Register   ");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(createTitle(appName));
        add(LayoutHelper.createRigidArea());
        add(createInfoPanel());
        add(LayoutHelper.createRigidArea());
        add(createButtonsPanel());
    }

    private static JPanel createTitle(JLabel text)
    {
        JPanel panel = new JPanel();
        panel.add(text);
        
        return panel;
    }

    private JPanel createInfoPanel( )
    {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(8, 2, 0, 4));

        panel.add(new JLabel("Name"));
        panel.add(userTextField);
        panel.add(new JLabel("Create Password"));
        panel.add(passwordTextField);
        panel.add(new JLabel("Confirm Password"));
        panel.add(passwordTextField2);
        panel.add(new JLabel("Adress"));
        panel.add(adresTextField);
        panel.add(new JLabel("Email"));
        panel.add(mailAdressField);
        panel.add(new JLabel("Account Balance"));
        panel.add(accountBalanceField);
        
        return panel;
    }

    private JPanel createButtonsPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(LayoutHelper.createXLargeRigidArea());
        panel.add(backButton);
        panel.add(LayoutHelper.createLargeRigidArea());
        panel.add(registerButton);
        panel.add(LayoutHelper.createXLargeRigidArea());
        return panel;
    }

   public String getName(){
        return userTextField.getText();
   }

   public String getAdress(){
        return adresTextField.getText();
   }
   
   public String getMail(){
        return mailAdressField.getText();
    }

    public String getBalance(){
        return accountBalanceField.getText();
    }
   
    public char[] getPasswordText()
    {
        return passwordTextField.getPassword();
    }

    public char[] getConfPasswordText()
    {
        return passwordTextField2.getPassword();
    }

    public void addRegisterListener(ActionListener listener)
    {
        registerButton.addActionListener(listener);
    }

    public void removeRegisterListener(ActionListener listener)
    {
        registerButton.removeActionListener(listener);
    }

    public void addBackListener(ActionListener listener)
    {
        backButton.addActionListener(listener);
    }



}
