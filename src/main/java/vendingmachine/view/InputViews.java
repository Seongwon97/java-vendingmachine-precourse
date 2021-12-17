package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.view.OutputViews.printUserChange;

public class InputViews {
    public static String scanMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String scanProductInfo() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine();
    }

    public static String scanUserInput() {
        System.out.println("\n투입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String scanPurchase(int change) {
        printUserChange(change);
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }
}
