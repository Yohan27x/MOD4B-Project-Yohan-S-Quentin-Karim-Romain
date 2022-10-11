import Window;
import javax.swing.*;

import LoginView;

public class Program {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(Program::start);
    }

    private static void start()
    {
        useSystemLookAndFeel();
        LoginView view = new LoginView();
        Window window = new Window("APPLICATION", view);
        window.setVisible(true);
    }

    private static void useSystemLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
