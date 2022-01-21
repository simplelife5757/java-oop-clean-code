package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class RacingCarGameLauncher {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController(
                new ConsoleInputView(), new ConsoleOutputView(), new RandomMoveStrategy()
        );
        racingCarGameController.initAndPlay();
//        CarGameRequestDto carGameRequestDto = racingCarGameController.getCarGameRequestDto();

//        List<Car> cars = CarFactory.createCars(carGameRequestDto.getCarNames());
//        RacingCarGame racingCarGame = new RacingCarGame(cars, new RandomMoveStrategy());
//        racingCarGame.playAndRecord(carGameRequestDto.getRound());
//
//        racingCarGame.getRoundSnapShots();
        // TODO: implement here
        //RacingCarGameService; // play, getSnapShotDto(), getFinalWinner()
//        RacingCarGame racingCarGame = RacingCarGame.with(cars);
//        racingCarGame.play(5);

    }
}
