package vendingmachine.service;

import static vendingmachine.utils.Validator.checkValidPrice;

public class UserChangeService {
    public void saveUserInput(String userInput) {
        checkValidPrice(userInput);
    }
}
