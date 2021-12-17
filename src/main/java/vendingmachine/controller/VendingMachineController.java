package vendingmachine.controller;

import vendingmachine.service.MachineMoneyService;
import vendingmachine.service.ProductService;

import static vendingmachine.view.InputViews.scanMachineMoney;
import static vendingmachine.view.InputViews.scanProductInfo;
import static vendingmachine.view.OutputViews.printMachineCoinInfo;

public class VendingMachineController {
    private static final MachineMoneyService machineMoneyService = new MachineMoneyService();
    private static final ProductService productService = new ProductService();

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

}
