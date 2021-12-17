package vendingmachine.service;

import vendingmachine.repository.UserChangeRepository;

import static vendingmachine.utils.Validator.checkValidPrice;

public class UserChangeService {
    private static UserChangeRepository userChangeRepository = UserChangeRepository.getInstance();

    public void saveUserInput(String userInput) {
        userChangeRepository.initChange(checkValidPrice(userInput));
    }

    public int getUserChange() {
        return userChangeRepository.getChange();
    }
}
