package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.AlwaysForwardMoveStrategy;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleOutputViewTest {

    @Test
    void getFinalWinnerCarNames() {
        List<Car> cars = Arrays.stream(new Car[]{new Car("A", new AlwaysForwardMoveStrategy()), new Car("B", new AlwaysForwardMoveStrategy())}).collect(Collectors.toList());
        ConsoleOutputView consoleOutputView = new ConsoleOutputView();

        String finalWinningCarNames = consoleOutputView.getFinalWinningCarNames(cars);

        assertThat(finalWinningCarNames).isEqualTo("A, B");


    }
}