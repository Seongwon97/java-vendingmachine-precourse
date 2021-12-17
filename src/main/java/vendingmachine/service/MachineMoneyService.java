package vendingmachine.service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.repository.MachineMoneyRepository;

import java.util.HashMap;
import java.util.Map;

import static vendingmachine.domain.Coin.getAvilableCoinList;
import static vendingmachine.domain.Coin.getEnumCoin;
import static vendingmachine.utils.Validator.*;

public class MachineMoneyService {
    private static MachineMoneyRepository machineMoneyRepository;

    public void saveMoney(String input) {
        int money = checkValidInput(input);
        // 돈을 repository에 저장하기
        machineMoneyRepository = machineMoneyRepository.getInstance(saveCoinMap(money));
    }

    public int checkValidInput(String input) {
        int money = checkNotInteger(input);
        checkIsMinusInteger(money);
        checkDivideTen(money);
        return money;
    }

    public Map<Coin, Integer> saveCoinMap(int money) {
        Map<Coin, Integer> coinMap = initCoinMap();
        int currentMoney = money;
        while (currentMoney > 0) {
            int random = selectRandomCoin(currentMoney);
            int currentCoin = coinMap.get(getEnumCoin(random));
            coinMap.put(getEnumCoin(random), currentCoin + 1);
        }
        return coinMap;
    }

    private Map<Coin, Integer> initCoinMap() {
        Map<Coin, Integer> coinMap = new HashMap<>();
        Coin.getCoinList().stream()
                .forEach(coin -> coinMap.put(coin, 0));
        return coinMap;
    }

    private int selectRandomCoin(int currentMoney) {
        return Randoms.pickNumberInList(getAvilableCoinList(currentMoney));
    }


}
