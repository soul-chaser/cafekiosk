package sample.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}