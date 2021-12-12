package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.VendingMachine;

import static vendingmachine.constant.Constant.ERROR_NOT_INTEGER;
import static vendingmachine.view.InputUtils.inputInitMachineMoney;

public class VendingMachineController {

    VendingMachine vendingMachine;

    public void turnOn() {
        init();
    }

    private void init() {
        int inputMoney = getInitMachineMoney();
        vendingMachine = new VendingMachine(inputMoney);
    }

    private int getInitMachineMoney() {
        int inputMoney = 0;
        boolean flag = false;

        while (!flag) {
            try {
                inputMoney = Integer.parseInt(inputInitMachineMoney());
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_NOT_INTEGER);
            }
        }

        return inputMoney;
    }
}
