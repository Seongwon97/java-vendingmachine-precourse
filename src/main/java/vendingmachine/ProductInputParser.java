package vendingmachine;

import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

import static vendingmachine.Validator.*;

public class ProductInputParser {
    public void parseProduct(String input) {
        checkEmptyInput(input);
        String[] productList = input.split(";");
        for (String productStr : productList) {
            mappingProduct(productStr);
        }

//        return new Products();
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

    private int checkQuantity(String quantity) {
        return 1;
    }
}
