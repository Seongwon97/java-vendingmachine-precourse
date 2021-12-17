package vendingmachine.service;

import vendingmachine.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static vendingmachine.utils.Validator.*;

public class ProductService {

    public void saveProductInfo(String input) {
        // 파싱 & 검증
        parseAndValid(input);

        // 저장하기
    }

    public List<Product> parseAndValid(String input) {
        List<Product> productList = new ArrayList<>();
        String[] products = input.split(";");
        Arrays.stream(products).forEach(product -> productList.add(validProduct(product)));
        return productList;
    }

    public Product validProduct(String product) {
        checkProductSentence(product);

        String[] productInfo = product.substring(1, product.length() - 1).split(",");
        checkProductInfoSize(productInfo);
        checkProductName(productInfo[0]);
        int price = checkValidPrice(productInfo[1]);
        int quantity = checkValidQuantity(productInfo[2]);
        return new Product(productInfo[0], price, quantity);
    }


}
