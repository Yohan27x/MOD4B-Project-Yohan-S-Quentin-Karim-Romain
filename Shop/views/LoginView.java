package Shop.views;
import javax.swing.*;
import Shop.utility.LayoutHelper;

import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JPanel 
{
    private final JLabel appName;
    private final JTextField loginTextField;
    private final JPasswordField passwordTextField;
    private final JButton loginButton;
    private final JButton registerButton;


    public LoginView()
    {
        appName = createValueLabel("Welcome to e-Shop!");
        loginTextField = new JTextField();
        passwordTextField = new JPasswordField();
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(createTitle(appName));
        add(LayoutHelper.createLargeRigidArea());
        add(createUserPanel());
        add(LayoutHelper.createRigidArea());
        add(createButtonsPanel());

    }

    private static JLabel createValueLabel(String text)
    {
        JLabel label = new JLabel(text);
        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
        return label;
    }

    private static JPanel createTitle(JLabel text)
    {
        JPanel panel = new JPanel();
        panel.add(text);
        
        return panel;
    }

    private JPanel createUserPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 0, 0));

        panel.add(new JLabel("Login:"));
        panel.add(loginTextField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordTextField);
        return panel;
    }

    private JPanel createButtonsPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.add(LayoutHelper.createXLargeRigidArea());
        panel.add(loginButton);
        panel.add(LayoutHelper.createSmallRigidArea());
        panel.add(registerButton);
        panel.add(LayoutHelper.createXLargeRigidArea());
        return panel;
    }


    public String getLoginText()
    {
        return loginTextField.getText();
    }

    public char[] getPasswordText()
    {
        return passwordTextField.getPassword();
    }



    public void addLoginListener(ActionListener listener)
    {
        loginButton.addActionListener(listener);
    }

    public void removeLoginListener(ActionListener listener)
    {
        loginButton.removeActionListener(listener);
    }

    public void addRegisterListener(ActionListener listener)
    {
        registerButton.addActionListener(listener);
    }

    public void removeRegisterListener(ActionListener listener)
    {
        registerButton.removeActionListener(listener);
    }


}