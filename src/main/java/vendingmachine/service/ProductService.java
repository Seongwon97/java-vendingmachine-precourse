package vendingmachine.service;

import vendingmachine.domain.Product;
import vendingmachine.repository.ProductRepository;
import vendingmachine.view.InputViews;

import java.util.HashMap;
import java.util.Map;

import static vendingmachine.repository.ProductRepository.*;
import static vendingmachine.service.Validator.*;
import static vendingmachine.view.Messages.*;

public class ProductService {
    public static final String PRODUCT_OUTER_SEPORATOR = ";";
    public static final String PRODUCT_INNER_SEPERATOR = ",";
    public static final int PRODUCT_NAME_POSITION = 0;
    public static final int PRODUCT_PRICE_POSITION = 1;
    public static final int PRODUCT_QUANTITY_POSITION = 2;

    public void getProductList() {
        while (true) {
            String input = InputViews.inputProductList();
            try {
                parseProduct(input);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void parseProduct(String input) {
        Map<String, Product> productMap = new HashMap<>();
        checkEmptyInput(input);
        String[] productList = input.split(PRODUCT_OUTER_SEPORATOR);
        for (String productStr : productList) {
            Product temp = mappingProduct(productStr);
            productMap.put(temp.getName(), temp);
        }
        saveProductInfo(productMap);
    }

    private static Product mappingProduct(String productStr) {
        checkProductStrBracket(productStr);

        String[] productInfo = removeBracket(productStr).split(PRODUCT_INNER_SEPERATOR);
        checkProductNumOfInfo(productInfo);

        return new Product(checkName(productInfo[PRODUCT_NAME_POSITION])
                , checkPrice(productInfo[PRODUCT_PRICE_POSITION])
                , checkQuantity(productInfo[PRODUCT_QUANTITY_POSITION]));
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
        return quantity;
    }
}
