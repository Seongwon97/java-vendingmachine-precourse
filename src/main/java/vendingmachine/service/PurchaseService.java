package vendingmachine.service;

import vendingmachine.domain.Product;
import vendingmachine.repository.ProductRepository;
import vendingmachine.repository.UserChangeRepository;

import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.utils.ErrorMessage.*;
import static vendingmachine.utils.Validator.checkProductName;

public class PurchaseService {
    private static ProductRepository productRepository = ProductRepository.getInstance();
    private static UserChangeRepository userChangeRepository = UserChangeRepository.getInstance();

    public void validPurchaseProduct(String input, int change) {
        checkProductName(input);
        checkProductExist(productRepository.getProductList(), input, change);
    }

    private void checkProductExist(List<Product> productList, String input, int change) {
        for (Product product : productList) {
            if (product.getName().equals(input)) {
                checkProductSoldOut(product);
                checkMoneyEnough(product, change);
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_PRODUCT_NOT_EXIST);
    }

    private void checkProductSoldOut(Product product) {
        if (product.getQuantity() == 0) {
            throw new IllegalArgumentException(ERROR_PRODUCT_SOLD_OUT);
        }
    }

    private void checkMoneyEnough(Product product, int remainMoney) {
        if (product.getPrice() > remainMoney) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY);
        }
    }

    public void sell(String productName) {
        Product sellProduct = productRepository.getProductList().stream()
                .filter(product -> product.getName().equals(productName))
                .sequential()
                .collect(Collectors.toList()).get(0);
        productRepository.sellProduct(sellProduct);
        userChangeRepository.purchase(sellProduct.getPrice());
    }

    public boolean checkContinueToSell() {
        int remainMoney = userChangeRepository.getChange();
        int notSoldOutProductNum = productRepository.getProductList().stream()
                .filter(product -> product.getQuantity() != 0 && product.getPrice() <= remainMoney)
                .collect(Collectors.toList()).size();

        if (notSoldOutProductNum == 0) {
            return false;
        }
        return true;
    }
}
