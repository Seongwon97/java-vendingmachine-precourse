package vendingmachine.service;

import vendingmachine.domain.Product;
import vendingmachine.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static vendingmachine.utils.ErrorMessage.ERROR_PRODUCT_NOT_EXIST;
import static vendingmachine.utils.ErrorMessage.ERROR_PRODUCT_SOLD_OUT;
import static vendingmachine.utils.Validator.*;

public class ProductService {
    private static ProductRepository productRepository = ProductRepository.getInstance();

    public void saveProductInfo(String input) {
        productRepository.initProductInfo(parseAndValid(input));
    }

    private List<Product> parseAndValid(String input) {
        List<Product> productList = new ArrayList<>();
        String[] products = input.split(";");
        Arrays.stream(products).forEach(product -> productList.add(validProduct(product)));
        return productList;
    }

    private Product validProduct(String product) {
        checkProductSentence(product);

        String[] productInfo = product.substring(1, product.length() - 1).split(",");
        checkProductInfoSize(productInfo);
        checkProductName(productInfo[0]);
        int price = checkValidPrice(productInfo[1]);
        int quantity = checkValidQuantity(productInfo[2]);
        return new Product(productInfo[0], price, quantity);
    }

    public void validPurchaseProduct(String input) {
        checkProductName(input);
        checkProductExist(productRepository.getProductList(), input);
    }

    private void checkProductExist(List<Product> productList, String input) {
        for (Product product: productList) {
            if (product.getName().equals(input)) {
                checkProductSoldOut(product);
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



}
