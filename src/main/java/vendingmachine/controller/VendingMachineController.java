package vendingmachine.controller;

import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;

import static vendingmachine.utils.ProductInputParser.parseProduct;
import static vendingmachine.utils.Validator.checkNotString;
import static vendingmachine.utils.Validator.checkPositiveNumber;
import static vendingmachine.view.InputUtils.*;
import static vendingmachine.view.OutputUtils.printMachineInitCoin;

public class VendingMachineController {

    VendingMachine vendingMachine;

    public void turnOn() {
        init();
    }

    private void init() {
        vendingMachine = new VendingMachine();

        int inputMoney = getInitMachineMoney();
        vendingMachine.initRemainCoin(inputMoney);
        printMachineInitCoin(vendingMachine.getRemainCoin());

        vendingMachine.setProducts(getProductList());
        vendingMachine.setChange(getUserInputMoney());

    }

    private int getInitMachineMoney() {
        while (true) {
            String input = inputInitMachineMoney();
            try {
                int inputMoney = checkNotString(input);
                checkPositiveNumber(inputMoney);
                return inputMoney;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Products getProductList() {
        while (true) {
            String input = inputProductList();
            try {
                return parseProduct(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getUserInputMoney() {
        while (true) {
            String input = inputUserMoney();
            try {
                int inputMoney = checkNotString(input);
                checkPositiveNumber(inputMoney);
                return inputMoney;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
