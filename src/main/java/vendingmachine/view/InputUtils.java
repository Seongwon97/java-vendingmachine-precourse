package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.constant.Constant.*;

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

}
