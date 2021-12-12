package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.constant.Constant.INPUT_INIT_MONEY_MESSAGE;

public class InputUtils {

    public static String inputInitMachineMoney() {
        System.out.println(INPUT_INIT_MONEY_MESSAGE);
        return Console.readLine();
    }

}
