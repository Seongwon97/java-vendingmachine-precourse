package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.view.OutputViews.printUserChange;

public class InputViews {
    public static final String SCAN_MACHINE_MONEY = "\n자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String SCAN_PRODUCT_INFO = "\n상품명과 가격, 수량을 입력해 주세요.";
    public static final String SCAN_USER_INPUT = "\n투입 금액을 입력해 주세요.";
    public static final String SCAN_PURCHASE = "구매할 상품명을 입력해 주세요.";

    public static String scanMachineMoney() {
        System.out.println(SCAN_MACHINE_MONEY);
        return Console.readLine();
    }

    public static String scanProductInfo() {
        System.out.println(SCAN_PRODUCT_INFO);
        return Console.readLine();
    }

    public static String scanUserInput() {
        System.out.println(SCAN_USER_INPUT);
        return Console.readLine();
    }

    public static String scanPurchase(int change) {
        printUserChange(change);
        System.out.println(SCAN_PURCHASE);
        return Console.readLine();
    }
}
