package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.VendingMachine;

import static vendingmachine.Validator.checkNotString;
import static vendingmachine.Validator.checkPositiveNumber;
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
            String input = inputInitMachineMoney();
            try {
                inputMoney = checkNotString(input);
                checkPositiveNumber(inputMoney);
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return inputMoney;
    }
}
