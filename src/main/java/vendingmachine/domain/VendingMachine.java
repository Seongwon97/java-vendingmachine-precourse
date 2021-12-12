package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.constant.Constant.*;
import static vendingmachine.domain.Coin.*;

public class VendingMachine {

    private Map<Coin, Integer> remainCoin = new TreeMap<>();
    public Products products;

    private int change;

    public VendingMachine() {

    }

    public Map<Coin, Integer> getRemainCoin() {
        return remainCoin;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public void initRemainCoin(int initMoney) {
        for (Coin c : getCoinList()) {
            remainCoin.put(c, 0);
        }
        setRemainCoin(initMoney);
    }

    private void setRemainCoin(int initMoney) {
        int remainMoney = initMoney;
        while (remainMoney > 0) {
            int pickedCoin = pickRandomCoin(remainMoney);
            remainMoney -= pickedCoin;
            remainCoin.put(getEnumCoin(pickedCoin), remainCoin.get(getEnumCoin(pickedCoin)) + 1);
        }
    }

    private static int pickRandomCoin(int remainMoney) {
        return pickNumberInList(getAvailableCoinValueList(remainMoney));
    }

    public void isValidOrderName(String order) {
        if (!products.isExist(order)) {
            throw new IllegalArgumentException(ERROR_NOT_INVALID_ORDER_NAME);
        }
        if (!products.hasEnoughMoney(order, change)) {
            throw new IllegalArgumentException(ERROR_LESS_CHANGE);
        }
        if (!products.hasEnoughQuantity(order)) {
            throw new IllegalArgumentException(ERROR_LESS_QUANTITY);
        }
    }

    public void sellProduct(String name) {
        products.consume(name);
        change -= products.getProductPrice(name);
    }

    public boolean isAvailableKeepSell() {
        if (!products.availableToBuy(change)) {
            return false;
        }
        return true;
    }

    public ChangeDTO getFinalChange() {
        ChangeDTO changeDTO = new ChangeDTO();
        changeDTO.setFinalChange(change);

        return changeDTO;
    }



}
