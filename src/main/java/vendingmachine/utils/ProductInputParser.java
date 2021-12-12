package vendingmachine.utils;

import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

import java.util.HashMap;
import java.util.Map;

import static vendingmachine.utils.Validator.*;

public class ProductInputParser {

    public static Products parseProduct(String input) {
        Map<String, Product> productMap = new HashMap<>();
        checkEmptyInput(input);
        String[] productList = input.split(";");
        for (String productStr : productList) {
            Product temp = mappingProduct(productStr);
            productMap.put(temp.getName(), temp);
        }

        return new Products(productMap);
    }

    private static Product mappingProduct(String productStr) {
        checkProductStrBracket(productStr);

        String[] productInfo = removeBracket(productStr).split(",");
        checkProductNumOfInfo(productInfo);

        return new Product(checkName(productInfo[0])
                , checkPrice(productInfo[1])
                , checkQuantity(productInfo[2]));
    }

    private static String removeBracket(String productStr) {
        return productStr.substring(1, productStr.length() - 1);
    }

    private static String checkName(String name) {
        checkFrontBlank(name);
        return name;
    }

    private static int checkPrice(String priceStr) {
        int price = checkNotString(priceStr);
        checkPositiveNumber(price);
        checkPriceMinimumStandard(price);
        checkDivideByTen(price);
        return price;
    }

    private static int checkQuantity(String quantityStr) {
        int quantity = checkNotString(quantityStr);
        checkPositiveNumber(quantity);
        return 1;
    }
}
