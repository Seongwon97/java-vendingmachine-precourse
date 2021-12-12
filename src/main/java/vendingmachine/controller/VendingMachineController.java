package vendingmachine.controller;

import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;

import static vendingmachine.utils.ProductInputParser.parseProduct;
import static vendingmachine.utils.Validator.checkNotString;
import static vendingmachine.utils.Validator.checkPositiveNumber;
import static vendingmachine.view.InputUtils.inputInitMachineMoney;
import static vendingmachine.view.InputUtils.inputProductList;

public class VendingMachineController {

    VendingMachine vendingMachine;

    public void turnOn() {
        init();
    }

    private void init() {
        int inputMoney = getInitMachineMoney();
        vendingMachine = new VendingMachine(inputMoney, getProductList());
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
}
