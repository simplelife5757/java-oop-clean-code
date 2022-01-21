package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGameController {
    private InputView inputView;
    private OutputView outputView;
    private MoveStrategy<Integer> moveStrategy;
    private RacingCarGame racingCarGame;

    public RacingCarGameController(InputView inputView, OutputView outputView, MoveStrategy<Integer> moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void initAndPlay() {
        RequestDto requestDto = inputView.input();
        List<Car> cars = CarFactory.createCars(requestDto.getCarNames(), new RandomMoveStrategy());
        racingCarGame = new RacingCarGame(cars);

        racingCarGame.playAndRecord(requestDto.getRound());
    }
}
