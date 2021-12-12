package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.domain.Coin.*;

public class VendingMachine {

    private static Map<Coin, Integer> remainCoin = new TreeMap<>();
    public Products products;

    private int change;

    public VendingMachine() {

    }

    public Map<Coin, Integer> getRemainCoin() {
        return remainCoin;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public void initRemainCoin(int initMoney) {
        for (Coin c : getCoinList()) {
            remainCoin.put(c, 0);
        }
        setRemainCoin(initMoney);
    }

    private void setRemainCoin(int initMoney) {
        int remainMoney = initMoney;
        while (remainMoney > 0) {
            int pickedCoin = pickRandomCoin(remainMoney);
            remainMoney -= pickedCoin;
            remainCoin.put(getEnumCoin(pickedCoin), remainCoin.get(getEnumCoin(pickedCoin)) + 1);
        }
    }

    private static int pickRandomCoin(int remainMoney) {
        return pickNumberInList(getCoinValueList(remainMoney));
    }

}
