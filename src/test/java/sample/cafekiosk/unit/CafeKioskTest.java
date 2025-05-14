package sample.cafekiosk.unit;

import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.beverage.Americano;
import sample.cafekiosk.unit.beverage.Latte;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CafeKioskTest {

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

}