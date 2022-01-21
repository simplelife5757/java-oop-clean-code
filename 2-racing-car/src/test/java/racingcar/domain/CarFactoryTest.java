package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.AlwaysForwardMoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    void createCars() {
        // Given
        AlwaysForwardMoveStrategy moveStrategy = new AlwaysForwardMoveStrategy();
        List<String> carNames = Arrays.stream(new String[]{"John", "J"}).collect(Collectors.toList());

        // When
        List<Car> cars = CarFactory.createCars(carNames, moveStrategy);

        // Then
        Car firstCar = cars.get(0);
        assertThat(firstCar.getName()).isEqualTo("John");
        assertThat(firstCar.getMoveStrategy()).isEqualTo(moveStrategy);

        Car secondCar = cars.get(1);
        assertThat(secondCar.getName()).isEqualTo("J");
        assertThat(secondCar.getMoveStrategy()).isEqualTo(moveStrategy);
    }
}