package vendingmachine.service;

import vendingmachine.domain.ChangeDto;
import vendingmachine.domain.Coin;
import vendingmachine.repository.MachineMoneyRepository;
import vendingmachine.repository.UserChangeRepository;

import java.util.Map;

public class ChangeService {
    static final MachineMoneyRepository machineMoneyRepository = MachineMoneyRepository.getInstance();
    static final UserChangeRepository userChangeRepository = UserChangeRepository.getInstance();


    public ChangeDto getFinalChange() {
        int remainMoney = userChangeRepository.getChange();
        Map<Coin, Integer> machineCoin = machineMoneyRepository.getMachineCoin();
        ChangeDto changeDto = new ChangeDto();

        for (Coin coin : Coin.getCoinList()) {
            int changeCoinNum = findChangeCoin(coin, machineCoin, remainMoney);
            remainMoney -= (coin.getAmount() * changeCoinNum);
            changeDto.addChange(coin, changeCoinNum);
        }
        return changeDto;
    }

    private int findChangeCoin(Coin coin, Map<Coin, Integer> machineCoin, int remainMoney) {
        int maxCoinNum = remainMoney / coin.getAmount();
        int machineCoinNum = machineCoin.get(coin);
        if (maxCoinNum <= machineCoinNum) {
            return maxCoinNum;
        }
        if (maxCoinNum > machineCoinNum) {
            return machineCoinNum;
        }
        return 0;
    }
}
