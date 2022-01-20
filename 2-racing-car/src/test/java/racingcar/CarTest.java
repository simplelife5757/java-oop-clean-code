package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void move_일보_전진() {
        // Given
        Car car = new Car("John", new AlwaysForwardMoveStrategy());

        // When
        car.move();

        // Then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void move_두번_전진() {
        // Given
        Car car = new Car("John", new AlwaysForwardMoveStrategy());

        // When
        car.move();
        car.move();

        // Then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void snapShot_일보_전진() {
        // Given
        Car car = new Car("John", new AlwaysForwardMoveStrategy());

        // When
        car.move();

        // Then
        assertThat(car.snapShot()).isEqualTo(new CarSnapShot(1, "John"));
    }
}