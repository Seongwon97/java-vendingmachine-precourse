package vendingmachine.domain;

import java.util.Map;

public class Products {
    private final Map<String, Product> productList;

    public Products(Map<String, Product> productList) {
        this.productList = productList;
    }

    public void consume(String name) {
        Product product = productList.get(name);
        product.consumeProduct();
    }

    public boolean isExist(String name) {
        if (!productList.containsKey(name)) {
            return false;
        }
        return true;
    }

    public boolean hasEnoughMoney(String name, int change) {
        if (change < productList.get(name).getPrice()) {
            return false;
        }
        return true;
    }

    public boolean hasEnoughQuantity(String name) {
        if (productList.get(name).getQuantity() > 0) {
            return true;
        }
        return false;
    }

    public int getProductPrice(String name) {
        return productList.get(name).getPrice();
    }


    public boolean availableToBuy(int change) {
        boolean canBuy = false;
        for (String name : productList.keySet()) {
            if (productList.get(name).getPrice() < change
                    && productList.get(name).getQuantity() > 0) {
                canBuy = true;
                return canBuy;
            }
        }
        return canBuy;
    }


}
