package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.utils.Validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static vendingmachine.view.Messages.ERROR_NEGATIVE_NUMBER;
import static vendingmachine.view.Messages.ERROR_NOT_INTEGER;

class ValidatorTest {
    Validator validator = new Validator();

    @DisplayName("숫자가 아닌 문자 입력시 Exception발생 테스트")
    @Test
    void checkNotStringTest() throws NoSuchMethodException {
        Method method = validator.getClass().getDeclaredMethod("checkNotString", String.class);
        method.setAccessible(true);

        try {
            method.invoke(validator, "잘못 된 값");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println(e.getCause().getMessage());
            assertThat(e.getCause().getMessage()).isEqualTo(ERROR_NOT_INTEGER);
        }
    }

    @DisplayName("양수가 아닌 값 입력 시 Exception발생 테스트")
    @Test
    void checkPositiveNumberTest() throws NoSuchMethodException {
        Method method = validator.getClass().getDeclaredMethod("checkPositiveNumber", int.class);
        method.setAccessible(true);

        try {
            method.invoke(validator, -122);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println(e.getCause().getMessage());
            assertThat(e.getCause().getMessage()).isEqualTo(ERROR_NEGATIVE_NUMBER);
        }
    }

}