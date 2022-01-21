package stringcalculator;

public class StringCalculatorLauncher {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(new CustomSplitStrategy(), new PositiveIntegerParseStrategy());
    }
}
