package vendingmachine.repository;

import vendingmachine.domain.Coin;

import java.util.Collections;
import java.util.Map;

public class MachineMoneyRepository {
    private static final MachineMoneyRepository instance = new MachineMoneyRepository();
    private static Map<Coin, Integer> machineCoin;

    private MachineMoneyRepository() {

    }

    public static MachineMoneyRepository getInstance() {
        return instance;
    }

    public Map<Coin, Integer> getMachineCoin() {
        return Collections.unmodifiableMap(machineCoin);
    }

    public void initMachieCoin(Map<Coin, Integer> machineCoin) {
        if (this.machineCoin == null) {
            this.machineCoin = machineCoin;
        }
    }
}
