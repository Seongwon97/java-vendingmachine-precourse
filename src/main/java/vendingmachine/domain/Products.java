package vendingmachine.domain;

import java.util.Map;

public class Products {
    private Map<String, Product> productList;

    public Products(Map<String, Product> productList) {
        this.productList = productList;
    }

    public void consume(String name) {
        if (!isExist(name)) {
            return;
        }
        Product product = productList.get(name);
        product.consumeProduct();
    }

    public boolean isExist(String name) {
        if (!productList.containsKey(name)) {
            return false;
        }
        if (productList.get(name).getQuantity() <= 0) {
            return false;
        }
        return true;
    }

    public boolean isValidConsume(String name, int change) {
        if (change < productList.get(name).getPrice()) {
            return false;
        }
        return true;
    }

}
