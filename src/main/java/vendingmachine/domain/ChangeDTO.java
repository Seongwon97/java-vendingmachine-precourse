package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static vendingmachine.domain.Coin.*;

public class ChangeDTO {
    public static final int NO_AVAILABLE_COIN = 0;

    public Map<Coin, Integer> changeMap = new TreeMap<>();

    public void setFinalChange(int remainChange) {
        for (int coin : getCoinValueList()) {
            if (remainChange / coin > NO_AVAILABLE_COIN) {
                int coinNum = remainChange / coin;
                changeMap.put(getEnumCoin(coin), coinNum);
                remainChange -= (coinNum * coin);
            }
        }
    }
}
