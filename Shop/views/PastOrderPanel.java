package Shop.views;

import Shop.formatting.CurrencyHelper;
import Shop.utility.LayoutHelper;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.text.NumberFormat;

public class PastOrderPanel extends JPanel {

    private final JLabel totalPrice;
    private final NumberFormat currencyFormatter;

    PastOrderPanel(double price){

        currencyFormatter = CurrencyHelper.getCurrencyFormatter();


        totalPrice = new JLabel(price + "£");

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        Border raisedetched;
        raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        setBorder(raisedetched);

  
        add(createOrderPanel());

    }

   
    public JPanel createOrderPanel(){
        JPanel panel = new JPanel();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));


        panel.add(createValueLabel("total price : "));
        panel.add(totalPrice);


        return panel;
    }

    private static JLabel createValueLabel(String text)
    {
        JLabel label = new JLabel(text);
        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
        return label;
    }
}
