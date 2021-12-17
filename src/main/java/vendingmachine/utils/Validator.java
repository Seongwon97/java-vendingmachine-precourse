package vendingmachine.utils;

import static vendingmachine.utils.ErrorMessage.*;

public class Validator {
    public static final char BLANK = ' ';
    public static final int MININUM_PRICE = 100;
    public static final int PRODUCT_ITEM_NUM = 3;
    public static final int MINIMUM_COIN = 10;
    public static final char PRODUCT_OPEN_BRACKET = '[';
    public static final char PRODUCT_CLOSE_BRACKET = ']';


    public static int checkValidPrice(String input) {
        int money = checkNotIntegerPrice(input);
        checkIsMinusInteger(money);
        checkDivideTen(money);
        return money;
    }

    public static int checkValidQuantity(String input) {
        int quantity = checkNotIntegerQuantity(input);
        checkIsMinusInteger(quantity);
        return quantity;
    }

    public static int checkNotIntegerPrice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER_MONEY);
        }
    }

    public static int checkNotIntegerQuantity(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER_QUANTITY);
        }
    }

    public static void checkIsMinusInteger(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ERROR_MINUS_INPUT);
        }
    }

    public static void checkDivideTen(int input) {
        if (input % MINIMUM_COIN != 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE_TEN);
        }
    }

    public static void checkProductSentence(String input) {
        if (input.charAt(0) != PRODUCT_OPEN_BRACKET ||
                input.charAt(input.length() - 1) != PRODUCT_CLOSE_BRACKET) {
            throw new IllegalArgumentException(ERROR_PRODUCT_BRACKET);
        }
    }

    public static void checkProductInfoSize(String[] productInfo) {
        if (productInfo.length != PRODUCT_ITEM_NUM) {
            throw new IllegalArgumentException(ERROR_PRODUCT_INFO_SIZE);
        }
    }

    public static void checkProductName(String input) {
        checkProductNameNone(input);
        checkProductNameFrontBlank(input);
    }

    private static void checkProductNameFrontBlank(String input) {
        if (input.charAt(0) == BLANK) {
            throw new IllegalArgumentException(ERROR_PRODUCT_NAME_FRONT_BLANK);
        }
    }

    private static void checkProductNameNone(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PRODUCT_NAME_NONE);
        }
    }

    public static void checkProcductMinimunPrice(int price) {
        if (price < MININUM_PRICE) {
            throw new IllegalArgumentException(ERROR_PRODUCT_MINIMUN_PRICE);
        }
    }
}
