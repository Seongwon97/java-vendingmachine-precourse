package vendingmachine.repository;

import vendingmachine.domain.Product;

import java.util.Collections;
import java.util.List;

public class ProductRepository {
    private static final ProductRepository instance = new ProductRepository();
    private static List<Product> productList;

    private ProductRepository() {

    }

    public static ProductRepository getInstance() {
        return instance;
    }

    public void initProductInfo(List<Product> productList) {
        if (this.productList == null) {
            this.productList = productList;
        }
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }
}
