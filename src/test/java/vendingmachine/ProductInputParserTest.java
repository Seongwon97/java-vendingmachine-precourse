package vendingmachine;

import org.junit.jupiter.api.Test;
import vendingmachine.utils.ProductInputParser;

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
        String input = "콜라,1500,20];[사이다,1000,10]";

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

    @Test
    void 숫자가_아닌_상품가격_테스트() {
        // given
        String input = "[콜라,오백원,20];[사이다,1000,10]";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_NOT_INTEGER);
    }

    @Test
    void 음수의_상품가격_테스트() {
        // given
        String input = "[콜라,-1000,20];[사이다,1000,10]";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_NEGATIVE_NUMBER);
    }

    @Test
    void 백원_미만의_상품가격_테스트() {
        // given
        String input = "[콜라,50,20];[사이다,1000,10]";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_PRICE_MINIMUN_STANDARD);
    }

    @Test
    void 십원으로_나뉘지_않는_상품가격_테스트() {
        // given
        String input = "[콜라,1053,20];[사이다,1000,10]";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_DIVIDE_BY_TEN);
    }

    @Test
    void 숫자가_아닌_상품수량_테스트() {
        // given
        String input = "[콜라,1500,상품수];[사이다,1000,10]";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_NOT_INTEGER);
    }

    @Test
    void 음수의_상품수량_테스트() {
        // given
        String input = "[콜라,1500,-20];[사이다,1000,10]";

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> productInputParser.parseProduct(input));

        // then
        System.out.println(exception.getMessage());
        assertThat(exception.getMessage()).isEqualTo(ERROR_NEGATIVE_NUMBER);
    }
}