package vendingmachine.view;

import vendingmachine.domain.ChangeDto;
import vendingmachine.domain.Coin;

import java.util.Map;

public class OutputViews {
    public static final String MACHINE_COIN = "\n자판기가 보유한 동전";
    public static final String WON = "원";
    public static final String SLASH = " - ";
    public static final String COUNT = "개";
    public static final String INSERT_MONEY = "\n투입 금액: ";
    public static final String FINAL_CHANGE = "잔돈";

    public static void printMachineCoinInfo(Map<Coin, Integer> machineCoin) {
        System.out.println(MACHINE_COIN);
        for (Coin coin : machineCoin.keySet()) {
            System.out.println(coin.getAmount() + WON + SLASH + machineCoin.get(coin) + COUNT);
        }
        System.out.println();
    }

    public static void printUserChange(int change) {
        System.out.println(INSERT_MONEY + change + WON);
    }

    public static void printFinalChange(ChangeDto changeDto) {
        System.out.println(FINAL_CHANGE);
        for (Coin coin : changeDto.getChangeKey()) {
            System.out.println(coin.getAmount() + WON + SLASH + changeDto.getCoinNum(coin) + COUNT);
        }
    }
}
