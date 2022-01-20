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
        cars = Arrays.stream(new Car[]{new Car("John", moveStrategy), new Car("Kay", moveStrategy)})
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
        assertThat(roundSnapShot.getCarSnapShots().get(0)).isEqualTo(new CarSnapShot(1, "John"));
        assertThat(roundSnapShot.getCarSnapShots().get(1)).isEqualTo(new CarSnapShot(1,  "Kay"));
    }

    @Test
    void playAndRecord_2회_기록() {
        RacingCarGame racingCarGame = new RacingCarGame(cars);

        // When
        racingCarGame.playAndRecord(2);

        // Then
        List<RoundSnapShot> roundSnapShots = racingCarGame.getRoundSnapShots();
        assertThat(roundSnapShots.size()).isEqualTo(2);

        RoundSnapShot firstRoundSnapShot = roundSnapShots.get(0);
        assertThat(firstRoundSnapShot.getRound()).isEqualTo(1);
        assertThat(firstRoundSnapShot.getCarSnapShots().get(0)).isEqualTo(new CarSnapShot(1, "John"));
        assertThat(firstRoundSnapShot.getCarSnapShots().get(1)).isEqualTo(new CarSnapShot(1, "Kay"));

        RoundSnapShot secondRoundSnapShot = roundSnapShots.get(1);
        assertThat(secondRoundSnapShot.getRound()).isEqualTo(2);
        assertThat(secondRoundSnapShot.getCarSnapShots().get(0)).isEqualTo(new CarSnapShot(2, "John"));
        assertThat(secondRoundSnapShot.getCarSnapShots().get(1)).isEqualTo(new CarSnapShot(2, "Kay"));
    }
}