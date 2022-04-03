package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarSnapShot;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RoundSnapShot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    List<Car> cars = new ArrayList<>();
    RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        OneStepMoveStrategy moveStrategy = new OneStepMoveStrategy();
        Car car1 = new Car("John", moveStrategy);
        Car car2 = new Car("J", moveStrategy);
        cars = Arrays.asList(car1, car2);
        racingCarGame = new RacingCarGame(cars);
    }

    @Test
    void play_자동차들_일보_전진() {
        // Given
        racingCarGame.play();

        // Expect
        assertThat(cars).allMatch(car -> car.getPosition() == 1);
    }

    @Test
    void recordRoundSnapShot_자동차들_일보_전진() {
        // Given
        racingCarGame.play();

        // When
        racingCarGame.recordRoundSnapShot();

        // Then
        RoundSnapShot roundSnapShot = racingCarGame.getRoundSnapShots().get(0);
        assertThat(roundSnapShot.getRound()).isEqualTo(1);
        assertThat(roundSnapShot.getCarSnapShots().get(0)).isEqualTo(new CarSnapShot(1, "John"));
        assertThat(roundSnapShot.getCarSnapShots().get(1)).isEqualTo(new CarSnapShot(1, "J"));
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
        assertThat(firstRoundSnapShot.getCarSnapShots().get(1)).isEqualTo(new CarSnapShot(1, "J"));

        RoundSnapShot secondRoundSnapShot = roundSnapShots.get(1);
        assertThat(secondRoundSnapShot.getRound()).isEqualTo(2);
        assertThat(secondRoundSnapShot.getCarSnapShots().get(0)).isEqualTo(new CarSnapShot(2, "John"));
        assertThat(secondRoundSnapShot.getCarSnapShots().get(1)).isEqualTo(new CarSnapShot(2, "J"));
    }

    @Test
    void getFinalWinner_공동_우승() {
        // Given
        cars.forEach(Car::move);

        // When
        List<Car> finalWinners = racingCarGame.getFinalWinners();

        // Then
        assertThat(finalWinners.size()).isEqualTo(2);

        Car finalWinner1 = finalWinners.get(0);
        assertThat(finalWinner1.getPosition()).isEqualTo(1);
        assertThat(finalWinner1.getName()).isEqualTo("John");

        Car finalWinner2 = finalWinners.get(1);
        assertThat(finalWinner2.getPosition()).isEqualTo(1);
        assertThat(finalWinner2.getName()).isEqualTo("J");
    }
}