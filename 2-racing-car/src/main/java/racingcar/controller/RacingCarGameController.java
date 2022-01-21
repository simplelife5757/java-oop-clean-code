package racingcar.controller;

import racingcar.domain.MoveStrategy;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RandomMoveStrategy;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameController {

    public void initAndPlay() {
        RequestDto requestDto = InputView.input();
        List<Car> cars = createCars(requestDto.getCarNames(), new RandomMoveStrategy());
        RacingCarGame racingCarGame = new RacingCarGame(cars);

        racingCarGame.playAndRecord(requestDto.getRound());
        OutputView.printRoundResult(racingCarGame.getRoundSnapShots());
        OutputView.printFinalWinningCarNames(racingCarGame.getFinalWinners());
    }

    public List<Car> createCars(List<String> carNames, MoveStrategy<Integer> moveStrategy) {
        return carNames.stream()
                .map(carName -> new Car(carName, moveStrategy))
                .collect(Collectors.toList());
    }
}
