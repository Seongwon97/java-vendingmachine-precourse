package vendingmachine;

import static vendingmachine.constant.Constant.ERROR_NEGATIVE_NUMBER;
import static vendingmachine.constant.Constant.ERROR_NOT_INTEGER;
import static vendingmachine.view.InputUtils.inputInitMachineMoney;

public class Validator {

    public static int checkNotString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    public static void checkPositiveNumber(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
        }
    }
}
