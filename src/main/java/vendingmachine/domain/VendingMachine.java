package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.domain.Coin.*;

public class VendingMachine {

    private Map<Coin, Integer> remainCoin = new TreeMap<>();
    public Products products;
    private int initMoney;

    public VendingMachine(int initMoney, Products products) {
        initRemainCoin(initMoney);
        this.products = products;
        this.initMoney = initMoney;
    }

    public int getInitMoney() {
        return initMoney;
    }

    public Map<Coin, Integer> getRemainCoin() {
        return remainCoin;
    }

    private void initRemainCoin(int initMoney) {
        for (Coin c: getCoinList()) {
            remainCoin.put(c, 0);
        }
        setRemainCoin(initMoney);
    }

    private void setRemainCoin(int initMoney) {
        int remainMoney = initMoney;
        while (remainMoney > 0) {
            int pickedCoin = pickRandomCoin();
            if (checkAddCoinAvailable(remainMoney, pickedCoin)) {
                remainMoney -= pickedCoin;
                remainCoin.put(getEnumCoin(pickedCoin), remainCoin.get(getEnumCoin(pickedCoin))+1);
            }
        }
    }

    private static int pickRandomCoin() {
        return pickNumberInList(getCoinValueList());
    }

    private static boolean checkAddCoinAvailable(int remainMoney, int coin) {
        if (remainMoney < coin) {
            return false;
        }
        return true;
    }
}
