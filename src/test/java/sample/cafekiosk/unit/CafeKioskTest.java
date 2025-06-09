package sample.cafekiosk.unit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.beverage.Americano;
import sample.cafekiosk.unit.beverage.Latte;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CafeKioskTest {

//    @DisplayName("음료 1개 추가 테스트")
    @DisplayName("음료 1개를 추가하면 주문 목록에 담긴다.")
    @Test
    void addManualTest() {
        // Given
        CafeKiosk cafeKiosk = new CafeKiosk();

        // When
        cafeKiosk.add(new Americano());

        // Then
        System.out.println(">>> 담긴 음료 수 : " + cafeKiosk.getBeverages().size());
        System.out.println(">>> 담긴 음료 : " + cafeKiosk.getBeverages().get(0).getName());

    }

    @Test
    void itCanAddNewBeverage() {
        // Given
        CafeKiosk cafeKiosk = new CafeKiosk();

        // When
        cafeKiosk.add(new Americano());

        // Then
        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(1);
        assertThat(cafeKiosk.getBeverages()).hasSize(1);
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void itCanAddSeveralBeverages() {
        // Given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        // When
        cafeKiosk.add(americano, 2);

        // Then
        assertThat(cafeKiosk.getBeverages()).hasSize(2);
        assertThat(cafeKiosk.getBeverages().get(0)).isEqualTo(americano);
        assertThat(cafeKiosk.getBeverages().get(1)).isEqualTo(americano);
    }

    @Test
    void itCanNotAddZeroBeverage() {
        // Given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        // When & Then
        assertThatThrownBy(() -> cafeKiosk.add(americano, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음료는 1잔 이상 주문하실 수 있습니다.");
    }

    @Test
    void itCanRemoveBeverage() {
        // Given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);
        assertThat(cafeKiosk.getBeverages()).hasSize(1);

        // When
        cafeKiosk.remove(americano);

        // Then
        assertThat(cafeKiosk.getBeverages()).hasSize(0);
        assertThat(cafeKiosk.getBeverages()).isEmpty();
    }

    @Test
    void itCanClearBeverages() {
        // Given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafeKiosk.add(americano);
        cafeKiosk.add(latte);
        assertThat(cafeKiosk.getBeverages()).hasSize(2);

        // When
        cafeKiosk.clear();

        // Then
        assertThat(cafeKiosk.getBeverages()).isEmpty();
    }

    @DisplayName("주문 목록에 담긴 삼품들의 총 금액을 계산할 수 있다.")
    @Test
    void itCalculateTotalPrice() {
        // Given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafeKiosk.add(americano);
        cafeKiosk.add(latte);

        // When
        int totalPrice = cafeKiosk.calculateTotalPrice();

        // Then
        assertThat(totalPrice).isEqualTo(8500);
    }

    @Disabled
    @Test
    void itMaybeCouldCreateOrder() {
        // Given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);

        // When
        Order order = cafeKiosk.createOrder(); // test 실행 시간에 따라 실패 할 수도 있음

        // Then
        assertThat(order.getBeverages()).hasSize(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void itCouldAlwaysCreateOrderWithCurrentTime() {
        // Given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);

        // When
        Order order = cafeKiosk.createOrder(LocalDateTime.of(2025, 5, 14, 10, 0));

        // Then
        assertThat(order.getBeverages()).hasSize(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void itCouldNotCreateOrderWithOutsideOpenTime() {
        // Given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);

        // When & Then
        assertThatThrownBy(()-> cafeKiosk.createOrder(LocalDateTime.of(2025, 5, 14, 9, 59)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문시간이 아닙니다. 관리자에게 문의하세요.");
    }

}