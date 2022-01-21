package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarSnapShot;
import racingcar.domain.RoundSnapShot;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void output() {
        System.out.println("This is output");
    }

    @Override
    public void outputRoundResult(List<RoundSnapShot> roundSnapShots) {
        System.out.println("실행 결과");
        roundSnapShots.forEach(this::outputRoundSnapShot);
    }

    private void outputRoundSnapShot(RoundSnapShot roundSnapShot) {
        roundSnapShot.getCarSnapShots().forEach(this::outputCarSnapShot);
        System.out.println();
    }

    private void outputCarSnapShot(CarSnapShot carSnapShot) {
        String position = new String(new char[carSnapShot.getPosition()]).replace("\0", "-");
        System.out.println(String.format("%s : %s", carSnapShot.getName(), position));
    }

    @Override
    public void outputFinalWinningCarNames(List<Car> cars) {
        String finalWinnerNames = getFinalWinningCarNames(cars);
        System.out.println(String.format("%s가 최종 우승했습니다.", finalWinnerNames));
    }

    public String getFinalWinningCarNames(List<Car> cars) {
        if (cars.size() == 1) {
            return cars.get(0).getName();
        }

        return cars.stream().map(Car::getName).reduce((s, s2) -> String.format("%s, %s", s, s2)).orElse("");
    }
}
