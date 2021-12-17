package vendingmachine.service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.repository.MachineMoneyRepository;

import java.util.Map;
import java.util.TreeMap;

import static vendingmachine.domain.Coin.getAvilableCoinList;
import static vendingmachine.domain.Coin.getEnumCoin;
import static vendingmachine.utils.Validator.checkValidPrice;

public class MachineMoneyService {
    private static MachineMoneyRepository machineMoneyRepository = MachineMoneyRepository.getInstance();

    public void saveMoney(String input) {
        int money = checkValidPrice(input);
        machineMoneyRepository.initMachieCoin(saveCoinMap(money));
    }

    private Map<Coin, Integer> saveCoinMap(int money) {
        Map<Coin, Integer> coinMap = initCoinMap();
        int currentMoney = money;
        while (currentMoney > 0) {
            int random = selectRandomCoin(currentMoney);
            int currentCoin = coinMap.get(getEnumCoin(random));
            coinMap.put(getEnumCoin(random), currentCoin + 1);
            currentMoney -= random;
        }
        return coinMap;
    }

    private Map<Coin, Integer> initCoinMap() {
        Map<Coin, Integer> coinMap = new TreeMap<>();
        Coin.getCoinList().stream()
                .forEach(coin -> coinMap.put(coin, 0));
        return coinMap;
    }

    private int selectRandomCoin(int currentMoney) {
        return Randoms.pickNumberInList(getAvilableCoinList(currentMoney));
    }

    public Map<Coin, Integer> getMachineCoinInfo() {
        return machineMoneyRepository.getMachineCoin();
    }
}
