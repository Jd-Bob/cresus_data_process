package mg.orange.cresus.utils;

import java.math.BigDecimal;

public abstract class DecimalUtils {

    public static double getDecimalPart(double value) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(value));
        int intValue = bigDecimal.intValue();

        return Double.parseDouble(bigDecimal.subtract(new BigDecimal(intValue)).toPlainString());
    }

    public static int getUnitPart(double value) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(value));

        return bigDecimal.intValue();
    }
}
