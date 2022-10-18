package Shop.views;
import javax.swing.*;

import Shop.models.Account;
import Shop.utility.LayoutHelper;
import java.awt.*;
import java.awt.event.ActionListener;


public class MainView extends JPanel{
    private String userName;
    private final JLabel welcomeMessage;
    private final JButton browseButton;
    private final JButton cartButton;
    private final JButton pastOrderButton;
    private final JButton storeBalanceButton;

    public MainView(){


        welcomeMessage = createValueLabel("Welcome " + userName);

        browseButton = new JButton("   BrowseProduct   ");
        pastOrderButton = new JButton("   ViewPastOrders   ");
        storeBalanceButton = new JButton("   AdjustBalance   ");
        cartButton = new JButton("   ViewCart   ");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(createTitle(welcomeMessage));
        add(createBrowseButton());
        add(createViewOrderBalanceButton());


    }

    public void initialize(Account account)
    {
        welcomeMessage.setText("Welcome, " + account.getName() + "!");
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
}
