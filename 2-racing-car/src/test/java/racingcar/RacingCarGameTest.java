package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameTest {
    AlwaysForwardMoveStrategy moveStrategy = new AlwaysForwardMoveStrategy();
    List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.stream(new Car[]{new Car("John", moveStrategy), new Car("John", moveStrategy)})
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

    @Test
    void recordRoundSnapShot_자동차들_일보_전진() {
        // Given
        RacingCarGame racingCarGame = new RacingCarGame(cars);
        racingCarGame.play();

        // When
        racingCarGame.recordRoundSnapShot();

        // Then
        RoundSnapShot roundSnapShot = racingCarGame.getRoundSnapShots().get(0);
        assertThat(roundSnapShot.getRound()).isEqualTo(1);
        assertTrue(roundSnapShot.getCarSnapShotList()
                .stream()
                .allMatch(carSnapShot -> carSnapShot.getPosition() == 1));
    }
}