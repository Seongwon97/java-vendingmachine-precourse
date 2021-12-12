package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    Map<Coin, Integer> remainCoin = new HashMap<>();
//    List<Product> products = new ArrayList<>();
    int change;

    public VendingMachine(int change) {
        this.change = change;
    }

    public int getChange() {
        return change;
    }

    public Map<Coin, Integer> getRemainCoin() {
        return remainCoin;
    }
}
