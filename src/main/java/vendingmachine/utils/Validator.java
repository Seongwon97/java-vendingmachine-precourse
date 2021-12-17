package vendingmachine.utils;

import static vendingmachine.utils.ErrorMessage.*;

public class Validator {
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
        if (input % 10 != 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE_TEN);
        }
    }

    public static void checkProductSentence(String input) {
        if (input.charAt(0) != '[' || input.charAt(input.length()-1) != ']') {
            throw new IllegalArgumentException(ERROR_PRODUCT_BRACKET);
        }
    }

    public static void checkProductInfoSize(String[] productInfo) {
        if (productInfo.length != 3) {
            throw new IllegalArgumentException(ERROR_PRODUCT_INFO_SIZE);
        }
    }

    public static void checkProductName(String input) {
        checkProductNameNone(input);
        checkProductNameFrontBlank(input);
    }

    private static void checkProductNameFrontBlank(String input) {
        if (input.charAt(0) == ' ') {
            throw new IllegalArgumentException(ERROR_PRODUCT_NAME_FRONT_BLANK);
        }
    }

    private static void checkProductNameNone(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PRODUCT_NAME_NONE);
        }
    }

    public static void checkProcductMinimunPrice(int price) {
        if (price < 100) {
            throw new IllegalArgumentException(ERROR_PRODUCT_MINIMUN_PRICE);
        }
    }

}
