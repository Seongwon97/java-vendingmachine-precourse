package vendingmachine.repository;

import vendingmachine.domain.Coin;

import java.util.Map;

public class MachineMoneyRepository {
    private static MachineMoneyRepository instance;
    private static Map<Coin, Integer> machineCoin;

    private MachineMoneyRepository() {

    }

    public MachineMoneyRepository getInstance(Map<Coin, Integer> machineCoin) {
        if (instance == null) {
            instance = new MachineMoneyRepository();
            this.machineCoin = machineCoin;
        }
        return instance;
    }


}
