package vendingmachine.service;

import static vendingmachine.utils.Validator.*;

public class MachineMoneyService {

    public void saveMoney(String input) {
        int money = checkValidInput(input);
        // 돈을 repository에 저장하기
    }

    public int checkValidInput(String input) {
        int money = checkNotInteger(input);
        checkIsMinusInteger(money);
        checkDivideTen(money);
        return money;
    }
}
