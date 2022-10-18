package Shop.utility;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    private static final Dimension zeroSize = new Dimension(0, 0);
    public Window(String title, Container contentPane)
    {
        this(title, contentPane, true);
    }
    public Window(String title, boolean resizable)
    {
        this(title, new JPanel(), resizable);
    }

    public Window(String title, Container contentPane, boolean resizable)
    {
        super(title);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        
        pack();
        setMinimumSize(getSize());
        setResizable(resizable);
    }

    @Override
    public void setContentPane(Container contentPane)
    {
        super.setContentPane(contentPane);

        setMinimumSize(zeroSize);
        pack();
        setMinimumSize(getSize());
    }


}