package vendingmachine.controller;

import vendingmachine.service.MachineMoneyService;
import vendingmachine.service.ProductService;
import vendingmachine.service.PurchaseService;
import vendingmachine.service.UserChangeService;

import static vendingmachine.view.InputViews.*;
import static vendingmachine.view.OutputViews.printMachineCoinInfo;
import static vendingmachine.view.OutputViews.printUserChange;

public class VendingMachineController {
    private static final MachineMoneyService machineMoneyService = new MachineMoneyService();
    private static final ProductService productService = new ProductService();
    private static final UserChangeService userChangeService = new UserChangeService();
    public static final PurchaseService purchaseService = new PurchaseService();

    public void run() {
        initMachineMoney();
        initProductInfo();
        initUserChange();
        while (purchaseService.checkContinueToSell()) { // 멈추는 조건 추가
            getPurchase();
        }
    }

    public void initMachineMoney() {
        boolean flag = false;
        while (!flag)
            try {
                String money = scanMachineMoney();
                machineMoneyService.saveMoney(money);
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        printMachineCoinInfo(machineMoneyService.getMachineCoinInfo());
    }

    public void initProductInfo() {
        boolean flag = false;
        while (!flag) {
            try {
                String products = scanProductInfo();
                productService.saveProductInfo(products);
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void initUserChange() {
        boolean flag = false;
        while(!flag) {
            try {
                String userChange = scanUserInput();
                userChangeService.saveUserInput(userChange);
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getPurchase() {
        boolean flag = false;
        while(!flag) {
            try {
                int change = userChangeService.getUserChange();
                String order = scanPurchase(change);
                purchaseService.validPurchaseProduct(order, userChangeService.getUserChange());
                purchaseService.sell(order);
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
