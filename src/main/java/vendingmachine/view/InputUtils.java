package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.constant.Constant.*;
import static vendingmachine.view.OutputUtils.printChangeMessage;

public class InputUtils {

    public static String inputInitMachineMoney() {
        System.out.println(INPUT_INIT_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String inputProductList() {
        System.out.println(INPUT_PRODUCT_LIST_MESSAGE);
        return Console.readLine();
    }

    public static String inputUserMoney() {
        System.out.println(INPUT_USER_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String inputOrderMessage(int change) {
        printChangeMessage(change);
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }

}
