package vendingmachine.controller;

import vendingmachine.domain.ChangeDTO;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;

import static vendingmachine.constant.Constant.*;
import static vendingmachine.utils.ProductInputParser.parseProduct;
import static vendingmachine.utils.Validator.*;
import static vendingmachine.view.InputUtils.*;
import static vendingmachine.view.OutputUtils.*;

public class VendingMachineController {
    VendingMachine vendingMachine;

    public void turnOn() {
        init();
        while (vendingMachine.isAvailableKeepSell()) {
            vendingMachine.sellProduct(getUserOrder());
        }

        ChangeDTO finalChange = vendingMachine.getFinalChange();
        printFinalChange(finalChange, vendingMachine.getChange());
    }

    private void init() {
        vendingMachine = new VendingMachine();
        vendingMachine.initRemainCoin(getInitMachineMoney());
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
                checkDivideByTen(inputMoney);
                return inputMoney;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    private Products getProductList() {
        while (true) {
            String input = inputProductList();
            try {
                return parseProduct(input);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
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
                printErrorMessage(e);
            }
        }
    }

    private String getUserOrder() {
        while (true) {
            try {
                String order = inputOrderMessage(vendingMachine.getChange());
                vendingMachine.isValidOrderName(order);
                return order;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }
}
