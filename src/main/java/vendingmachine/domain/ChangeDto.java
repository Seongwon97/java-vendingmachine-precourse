package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

public class ChangeDto {
    Map<Coin, Integer> change;

    public ChangeDto() {
        change = new TreeMap<>();
    }

    public void addChange(Coin coin, int coinNum) {
        change.put(coin, coinNum);
    }
}
