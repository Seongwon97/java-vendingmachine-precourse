package vendingmachine.utils;

public class ErrorMessage {
    public static final String ERROR_NOT_INTEGER_MONEY = "[ERROR] 금액은 숫자여야 합니다.\n";
    public static final String ERROR_MINUS_INPUT = "[ERROR] 음수의 값이 입력되었습니다.\n";
    public static final String ERROR_DIVIDE_TEN = "[ERROR] 금액은 10으로 나누어 떨어져야 합니다.\n";
    public static final String ERROR_PRODUCT_BRACKET = "[ERROR] 상품 정보는 대괄호로 묶여 있어야 합니다.\n";
    public static final String ERROR_PRODUCT_INFO_SIZE = "[ERROR] 상품 정보는 [이름,가격,수량]의 형태로 입력되어야 합니다.\n";
    public static final String ERROR_PRODUCT_NAME_FRONT_BLANK = "[ERROR] 상품 이름의 앞에 공백이 있습니다.\n";
    public static final String ERROR_PRODUCT_NAME_NONE = "[ERROR] 상품 이름이 입력되지 않았습니다.\n";
}
