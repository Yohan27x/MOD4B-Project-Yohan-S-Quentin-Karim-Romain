package Shop.formatting;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyHelper
{
    private CurrencyHelper()
    { }

    public static NumberFormat getCurrencyFormatter()
    {
        return getCurrencyFormatter(Locale.getDefault());
    }

    public static NumberFormat getCurrencyFormatter(Locale locale)
    {
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setMinimumFractionDigits(1);
        format.setMaximumFractionDigits(1);
        return format;
    }
}
