package Shop.views;
import javax.swing.*;

import Shop.models.Account;
import Shop.utility.LayoutHelper;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;


public class MainView extends JPanel{
    private String userName;
    private final JLabel welcomeMessage;
    private final JButton browseButton;
    private final JButton cartButton;
    private final JButton pastOrderButton;
    private final JButton storeBalanceButton;
    private final JButton logOutButton;


    final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
    final static String username = "java";
    final static String password = "password";
    public String nameUser () {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
                String query = "SELECT UserName FROM userdb WHERE logged=? ";
                PreparedStatement statement = connection.prepareStatement(query);
                
                statement.setBoolean(1, true);
               
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    return resultSet.getString("UserName");
                }
                
                
                
                
            } catch (SQLException e) {
                throw new IllegalStateException("Nique ?", e);
            }
        return "Unknown";
        }
    public MainView(){


        welcomeMessage = createValueLabel("Welcome " + nameUser());

        browseButton = new JButton("   BrowseProduct   ");
        pastOrderButton = new JButton("   ViewPastOrders   ");
        storeBalanceButton = new JButton("   AdjustBalance   ");
        cartButton = new JButton("   ViewCart   ");
        logOutButton = new JButton("   LogOut   ");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(createTitle(welcomeMessage));
        add(createBrowseButton());
        add(createViewOrderBalanceButton());
        add(createLogoutButton());


    }

    public void initialize(Account account)
    {
        welcomeMessage.setText("Welcome, " + nameUser() + "!");
    }


    private  JPanel createTitle(JLabel text) {
        JPanel panel = new JPanel();
        panel.add(text);
        panel.setBorder(LayoutHelper.addSmallMargin(LayoutHelper.createEmptyBorder()));

        return panel;
    }

    private JPanel createBrowseButton() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 5));
        panel.add(browseButton);
        panel.setBorder(LayoutHelper.addSmallMargin(LayoutHelper.createEmptyBorder()));
        panel.add(cartButton);

        return panel;

    }

    private JPanel createViewOrderBalanceButton() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 5));
        panel.add(pastOrderButton);
        panel.setBorder(LayoutHelper.addSmallMargin(LayoutHelper.createEmptyBorder()));
        panel.add(storeBalanceButton);

        return panel;

    }
    private JPanel createLogoutButton() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 3, 3));
        panel.add(logOutButton);
        return panel;

    }

    private static JLabel createValueLabel(String text)
    {
        JLabel label = new JLabel(text);
        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
        return label;
    }

    public void addBrowseListener(ActionListener listener){
        browseButton.addActionListener(listener);
    }

    public void addStoreBalanceListener(ActionListener listener){
        storeBalanceButton.addActionListener(listener);
    }

    public void addCartListener(ActionListener listener){
        cartButton.addActionListener(listener);
    }

    public void addPastOrdersListener(ActionListener listener){
        pastOrderButton.addActionListener(listener);
    }

    public void addLogOutListener(ActionListener listener){
        logOutButton.addActionListener(listener);
    }
}
