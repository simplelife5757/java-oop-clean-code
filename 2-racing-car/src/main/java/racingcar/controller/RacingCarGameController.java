package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGameController {
    private InputView inputView;
    private OutputView outputView;
    private RacingCarGame racingCarGame;

    public RacingCarGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void initAndPlay() {
        RequestDto requestDto = inputView.input();
        List<Car> cars = CarFactory.createCars(requestDto.getCarNames(), new RandomMoveStrategy());
        racingCarGame = new RacingCarGame(cars);

        racingCarGame.playAndRecord(requestDto.getRound());
    }

    public void outputRoundResult() {
        outputView.outputRoundResult(racingCarGame.getRoundSnapShots());
    }

    public void outputFinalWinningCarNames() {
        outputView.outputFinalWinningCarNames(racingCarGame.getFinalWinners());
    }
}
