package sample.cafekiosk.spring.domain.stock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    @DisplayName("재고의 수량이 제공된 수량보다 작은지 확인한다.")
    void isQuantityLessThan() {
        // Given
        Stock stock = Stock.create("001", 1);
        int quantity = 2;

        // When
        boolean actual = stock.isQuantityLessThan(quantity);

        // Then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("재고를 주어진 개수 만큼 차감할 수 있다.")
    void deductQuantity() {
        // Given
        Stock stock = Stock.create("001", 1);
        int quantity = 1;

        // When
        stock.deductQuantity(quantity);

        // Then
        assertThat(stock.getQuantity()).isZero();
    }

    @Test
    @DisplayName("재고보다 많은 수량으로 차감 시도하는 경우 예외가 발생 한다.")
    void deductQuantity2() {
        // Given
        Stock stock = Stock.create("001", 1);
        int quantity = 2;

        // When & Then
        assertThatThrownBy(() -> stock.deductQuantity(quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차감 할 재고 수량이 모자랍니다.");
    }

    @TestFactory
    @DisplayName("")
    Collection<DynamicTest> dynamicTest() {
        return List.of(
                DynamicTest.dynamicTest("", () -> {

                }),
                DynamicTest.dynamicTest("", () -> {

                })
        );
    }

    @TestFactory
    @DisplayName("재고 차감 시나리오")
    Collection<DynamicTest> stockDeductionDynamicTest() {
        // Given
        Stock stock = Stock.create("001", 1);

        return List.of(
                DynamicTest.dynamicTest("재고를 주어진 개수만큼 차감할 수 있다.", () -> {
                    // Given
                    int quantity = 1;

                    // When
                    stock.deductQuantity(quantity);

                    // Then
                    assertThat(stock.getQuantity()).isZero();
                }),
                DynamicTest.dynamicTest("재고보다 많은 수의 수량으로 차감 시도하는 경우 예외가 발생한다.", () -> {
                    // Given
                    int quantity = 1;

                    // When & Then
                    assertThatThrownBy(() -> stock.deductQuantity(quantity))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("차감 할 재고 수량이 모자랍니다.");
                })
        );
    }

}