package vendingmachine.controller;

import vendingmachine.service.MachineMoneyService;

import static vendingmachine.view.InputViews.scanMachineMoney;
import static vendingmachine.view.OutputViews.printMachineCoinInfo;

public class VendingMachineController {
    private static final MachineMoneyService machineMoneyService = new MachineMoneyService();

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
}
