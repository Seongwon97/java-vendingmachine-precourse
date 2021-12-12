package vendingmachine;

import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

import java.util.HashMap;
import java.util.Map;

import static vendingmachine.Validator.*;

public class ProductInputParser {

    public Products parseProduct(String input) {
        Map<String, Product> productMap = new HashMap<>();
        checkEmptyInput(input);
        String[] productList = input.split(";");
        for (String productStr : productList) {
            Product temp = mappingProduct(productStr);
            productMap.put(temp.getName(), temp);
        }

        return new Products(productMap);
    }

    private Product mappingProduct(String productStr) {
        checkProductStrBracket(productStr);

        String[] productInfo = productStr.split(",");
        checkProductNumOfInfo(productInfo);

        return new Product(checkName(productInfo[0])
                , checkPrice(productInfo[1])
                , checkQuantity(productInfo[2]));
    }

    private String checkName(String name) {
        checkFrontBlank(name);
        return name;
    }

    private int checkPrice(String priceStr) {
        int price = checkNotString(priceStr);
        checkPositiveNumber(price);
        checkPriceMinimumStandard(price);
        checkDivideByTen(price);
        return price;
    }

    private int checkQuantity(String quantityStr) {
        int quantity = checkNotString(quantityStr);
        checkPositiveNumber(quantity);
        return 1;
    }
}
