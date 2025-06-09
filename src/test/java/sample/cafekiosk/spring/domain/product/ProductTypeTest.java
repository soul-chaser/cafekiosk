package sample.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTypeTest {

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    void containsStockType() {
        // Given
        ProductType givenType = ProductType.HANDMADE;

        // When
        boolean actual = ProductType.containsStockType(givenType);

        // Then
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    void containsStockType2() {
        // Given
        ProductType givenType = ProductType.BAKERY;

        // When
        boolean actual = ProductType.containsStockType(givenType);

        // Then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지 체크한다.")
    void containsStockType3() {
        // Given
        ProductType givenType1 = ProductType.HANDMADE;
        ProductType givenType2 = ProductType.BOTTLE;
        ProductType givenType3 = ProductType.BAKERY;

        // When
        boolean result1 = ProductType.containsStockType(givenType1);
        boolean result2 = ProductType.containsStockType(givenType2);
        boolean result3 = ProductType.containsStockType(givenType3);

        // Then
        assertThat(result1).isFalse();
        assertThat(result2).isTrue();
        assertThat(result3).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
        "HANDMADE,false",
        "BOTTLE,true",
        "BAKERY,true"
    })
    @DisplayName("상품 타입이 재고 관련 타입인지 체크한다.")
    void containsStockType4(ProductType productType, boolean expected) {
        // When
        boolean result = ProductType.containsStockType(productType);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideProductTypesForCheckingStockType() {
        return Stream.of(
                Arguments.of(ProductType.HANDMADE, false),
                Arguments.of(ProductType.BOTTLE, true),
                Arguments.of(ProductType.BAKERY, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideProductTypesForCheckingStockType")
    @DisplayName("상품 타입이 재고 관련 타입인지 체크한다.")
    void containsStockType5(ProductType productType, boolean expected) {
        // When
        boolean result = ProductType.containsStockType(productType);

        // Then
        assertThat(result).isEqualTo(expected);
    }

}