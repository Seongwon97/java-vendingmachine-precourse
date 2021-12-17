package vendingmachine.utils;

import static vendingmachine.utils.ErrorMessage.*;

public class Validator {
    public static int checkNotInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER_MONEY);
        }
    }

    public static void checkIsMinusInteger(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ERROR_MINUS_INPUT);
        }
    }

    public static void checkDivideTen(int input) {
        if (input % 10 != 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE_TEN);
        }
    }


}
