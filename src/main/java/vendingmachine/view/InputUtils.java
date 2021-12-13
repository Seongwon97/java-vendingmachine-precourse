package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.view.Messages.*;
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
        System.out.println(INPUT_PRODUCT_NAME);
        return Console.readLine();
    }

}
