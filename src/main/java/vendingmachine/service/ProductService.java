package vendingmachine.service;

import vendingmachine.domain.Product;
import vendingmachine.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static vendingmachine.utils.Validator.*;

public class ProductService {
    private static final ProductRepository productRepository = ProductRepository.getInstance();
    public static final String PRODUCT_SEPORATOR = ";";
    public static final String PRODUCT_ITEM_SEPORATOR = ",";
    public static final int PRODUCT_NAME = 0;
    public static final int PRODUCT_PRICE = 1;
    public static final int PRODUCT_QUANTITY = 2;

    public void saveProductInfo(String input) {
        productRepository.initProductInfo(parseAndValid(input));
    }

    private List<Product> parseAndValid(String input) {
        List<Product> productList = new ArrayList<>();
        String[] products = input.split(PRODUCT_SEPORATOR);
        Arrays.stream(products).forEach(product -> productList.add(validProduct(product)));
        return productList;
    }

    private Product validProduct(String product) {
        checkProductSentence(product);

        String[] productInfo = product.substring(1, product.length() - 1).split(PRODUCT_ITEM_SEPORATOR);
        checkProductInfoSize(productInfo);
        checkProductName(productInfo[PRODUCT_NAME]);
        int price = checkValidPrice(productInfo[PRODUCT_PRICE]);
        checkProcductMinimunPrice(price);
        int quantity = checkValidQuantity(productInfo[PRODUCT_QUANTITY]);
        return new Product(productInfo[PRODUCT_NAME], price, quantity);
    }
}
