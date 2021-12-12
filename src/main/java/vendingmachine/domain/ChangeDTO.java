package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static vendingmachine.domain.Coin.*;

public class ChangeDTO {
    public Map<Coin, Integer> changeMap = new TreeMap<>();

    public void setFinalChange(int remainChange) {
        for (int coin : getCoinValueList()) {
            if (remainChange / coin > 0) {
                int coinNum = remainChange / coin;
                changeMap.put(getEnumCoin(coin), coinNum);
                remainChange -= (coinNum * coin);
            }
        }
    }

}
