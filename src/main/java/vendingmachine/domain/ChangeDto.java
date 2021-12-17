package vendingmachine.domain;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ChangeDto {
    Map<Coin, Integer> change;

    public ChangeDto() {
        change = new TreeMap<>();
    }

    public void addChange(Coin coin, int coinNum) {
        change.put(coin, coinNum);
    }

    public Map<Coin, Integer> getChange() {
        return change;
    }

    public Set<Coin> getChangeKey() {
        return change.keySet();
    }

    public int getCoinNum(Coin coin) {
        return change.get(coin);
    }
}
