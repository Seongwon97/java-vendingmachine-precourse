package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

public class OutputUtils {
    public static void printMachineInitCoin(Map<Coin, Integer> remainCoin) {
        for (Coin c: remainCoin.keySet()) {
            System.out.println(c.getAmount() + " - " + remainCoin.get(c) + "개");
        }
    }
}
