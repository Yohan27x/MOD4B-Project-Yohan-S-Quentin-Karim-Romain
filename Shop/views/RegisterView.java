package Shop.views;
import javax.swing.*;
import Shop.utility.LayoutHelper;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView extends JPanel{
    private final JLabel appName;
    private final JTextField userTextField;
    private final JTextField adresTextField;
    private final JTextField mailAdressField;
    private final JPasswordField passwordField;
    private final JTextField accountBalanceField;
    private final JButton backButton;
    private final JButton registerButton;

    public RegisterView(){
        appName = new JLabel("Register Page");
        userTextField = new JTextField();
        adresTextField = new JTextField();
        mailAdressField = new JTextField();
        passwordField = new JPasswordField();
        accountBalanceField = new JTextField();
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
        panel.setLayout(new GridLayout(5, 2, 0, 4));
        panel.add(new JLabel("Name"));
        panel.add(userTextField);
        panel.add(new JLabel("Adress"));
        panel.add(adresTextField);
        panel.add(new JLabel("Email"));
        panel.add(mailAdressField);
        panel.add(new JLabel("Password"));
        panel.add(passwordField);
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
        panel.add(LayoutHelper.createSmallRigidArea());
        panel.add(registerButton);
        panel.add(LayoutHelper.createXLargeRigidArea());
        return panel;
    }

    public void addBackListener(ActionListener listener)
    {
        backButton.addActionListener(listener);
    }


}
