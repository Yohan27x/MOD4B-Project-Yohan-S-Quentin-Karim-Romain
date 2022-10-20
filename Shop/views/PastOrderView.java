package Shop.views;

import Shop.formatting.CurrencyHelper;
import Shop.models.ListOfProducts;
import Shop.utility.LayoutHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PastOrderView extends JPanel {

    private final JButton backMainButton;

    private final JPanel allPastOrdersContainer;

    private ArrayList<JPanel> AllPastOrderPanels = new ArrayList<>();

    private final JScrollPane pastOrdersScrollPane;

    private final NumberFormat currencyFormatter;

    public PastOrderView(){

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();

        backMainButton = new JButton("BackMainPage");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(createTitle(createValueLabel("Your Past Orders")));

        allPastOrdersContainer = new JPanel();

        pastOrdersScrollPane = new JScrollPane(allPastOrdersContainer,   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pastOrdersScrollPane.setPreferredSize(new Dimension(243, 200));

        add(pastOrdersScrollPane);

        add(createButtonBackMain());
    }

    public void initialize(ArrayList<Double> listPastOrdersPrices){

        this.createAllPastOrderPanels(listPastOrdersPrices);
        allPastOrdersContainer.add(createAllPastOrdersContainer());

    }

    public void createAllPastOrderPanels(ArrayList<Double> listPastOrdersPrices){
        for (Double listPastOrdersPrice : listPastOrdersPrices) {
            PastOrderPanel pastOrderPanel = new PastOrderPanel(listPastOrdersPrice);
            AllPastOrderPanels.add(pastOrderPanel);
        }

    }

    public JPanel createAllPastOrdersContainer(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        for (JPanel allPastOrderPanel : AllPastOrderPanels) {
            panel.add(allPastOrderPanel);
            panel.add(LayoutHelper.createRigidArea());

        }

        return panel;
    }


    private  JPanel createTitle(JLabel text) {
        JPanel panel = new JPanel();
        panel.add(text);
        panel.setBorder(LayoutHelper.createEmptyBorder());

        return panel;
    }

    private  JPanel createButtonBackMain() {
        JPanel panel = new JPanel();

        panel.add(backMainButton);
        panel.setBorder(LayoutHelper.createEmptyBorder());

        return panel;
    }

    private static JLabel createValueLabel(String text)
    {
        JLabel label = new JLabel(text);
        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
        return label;
    }

    public void addBackMainListener(ActionListener listener)
    {
        backMainButton.addActionListener(listener);
    }

}
