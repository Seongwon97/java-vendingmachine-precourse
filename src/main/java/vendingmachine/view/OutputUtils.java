package vendingmachine.view;

import vendingmachine.domain.ChangeDTO;
import vendingmachine.domain.Coin;

import java.util.Map;

import static vendingmachine.view.Messages.PRINT_MACHINE_COIN_MESSAGE;

public class OutputUtils {
    public static final String REMAIN_MONEY = "잔돈";
    public static final String INSERT_MONEY = "\n투입 금액: ";
    public static final String WON = "원";
    public static final String COIN_PRINT_SEPORATOR = " - ";
    public static final String COIN_PRINT_UNIT = "개";

    public static void printMachineInitCoin(Map<Coin, Integer> remainCoin) {
        System.out.println(PRINT_MACHINE_COIN_MESSAGE);
        for (Coin c : remainCoin.keySet()) {
            System.out.println(c.getAmount() + WON + COIN_PRINT_SEPORATOR + remainCoin.get(c) + COIN_PRINT_UNIT);
        }
    }

    public static void printFinalChange(ChangeDTO changeDTO, int change) {
        printChangeMessage(change);
        System.out.println(REMAIN_MONEY);
        for (Coin coin : changeDTO.changeMap.keySet()) {
            System.out.println(coin.getAmount() + WON + COIN_PRINT_SEPORATOR + changeDTO.changeMap.get(coin) + COIN_PRINT_UNIT);
        }
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printChangeMessage(int change) {
        System.out.println(INSERT_MONEY + change + WON);
    }
}
