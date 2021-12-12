package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

import static vendingmachine.constant.Constant.PRINT_MACHINE_COIN_MESSAGE;

public class OutputUtils {
    public static void printMachineInitCoin(Map<Coin, Integer> remainCoin) {
        System.out.println(PRINT_MACHINE_COIN_MESSAGE);
        for (Coin c: remainCoin.keySet()) {
            System.out.println(c.getAmount() + " - " + remainCoin.get(c) + "개");
        }
    }
}
