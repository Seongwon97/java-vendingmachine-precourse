package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.constant.Constant.*;

class ProductInputParserTest {

    ProductInputParser productInputParser = new ProductInputParser();

    @Test
    void 비어있는_입력값_테스트() {
        // given
        String input = "";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_EMPTY_INPUT);
    }

    @Test
    void 잘못된_대괄호_테스트1() {
        // given
        String input = "[콜라,1500,20;[사이다,1000,10]";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_INVALID_BRACKET);
    }

    @Test
    void 잘못된_대괄호_테스트2() {
        // given
        String input = "[콜라,1500,20];[사이다,1000,10]";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_INVALID_BRACKET);
    }

    @Test
    void 부족한_상품정보_테스트() {
        // given
        String input = "[콜라];[사이다,10]";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_INVALID_PRODUCT_INPUT);
    }

    @Test
    void 공백으로_시작하는_상품_이름_테스트() {
        // given
        String input = "[ 콜라,1500,20];[사이다,1000,10]";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_PRODUCT_NAME_BLANK);
    }

}