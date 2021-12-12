package vendingmachine.view;

import vendingmachine.domain.ChangeDTO;
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

    public static void printFinalChange(ChangeDTO changeDTO, int change) {
        System.out.println("\n투입 금액: " + change);
        System.out.println("잔돈");
        for (Coin coin : changeDTO.changeMap.keySet()) {
            System.out.println(coin.getAmount() + " - " + changeDTO.changeMap.get(coin) + "개");
        }
    }
}
