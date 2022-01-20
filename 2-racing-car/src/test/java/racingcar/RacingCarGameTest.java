package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameTest {
    AlwaysForwardMoveStrategy moveStrategy = new AlwaysForwardMoveStrategy();
    List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.stream(new Car[]{new Car(moveStrategy), new Car(moveStrategy)})
                .collect(Collectors.toList());
    }

    @Test
    void play_자동차들_일보_전진() {
        // Given
        RacingCarGame racingCarGame = new RacingCarGame(cars);

        // When
        racingCarGame.play();

        // Then
        assertTrue(racingCarGame.getCars().stream().allMatch(car -> car.getPosition() == 1));
    }
}