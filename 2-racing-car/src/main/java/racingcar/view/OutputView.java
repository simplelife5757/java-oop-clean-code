package racingcar.view;

import racingcar.controller.RequestDto;
import racingcar.domain.Car;
import racingcar.domain.RoundSnapShot;

import java.util.List;

public interface OutputView {
    public void output();

    public void outputRoundResult(List<RoundSnapShot> roundSnapShotList);

    public void outputFinalWinningCarNames(List<Car> cars);
}
