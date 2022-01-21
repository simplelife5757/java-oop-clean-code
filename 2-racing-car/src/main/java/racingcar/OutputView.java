package racingcar;

import java.util.List;

public class OutputView {
    public static void printRoundResult(List<RoundSnapShot> roundSnapShots) {
        System.out.println("실행 결과");
        roundSnapShots.forEach(OutputView::printRoundSnapShot);
    }

    private static void printRoundSnapShot(RoundSnapShot roundSnapShot) {
        roundSnapShot.getCarSnapShots().forEach(OutputView::printCarSnapShot);
        System.out.println();
    }

    private static void printCarSnapShot(CarSnapShot carSnapShot) {
        String position = new String(new char[carSnapShot.getPosition()]).replace("\0", "-");
        System.out.println(String.format("%s : %s", carSnapShot.getName(), position));
    }

    public static void printFinalWinningCarNames(List<Car> cars) {
        String finalWinnerNames = getFinalWinningCarNames(cars);
        System.out.println(String.format("%s가 최종 우승했습니다.", finalWinnerNames));
    }

    public static String getFinalWinningCarNames(List<Car> cars) {
        if (cars.size() == 1) {
            return cars.get(0).getName();
        }

        return cars.stream().map(Car::getName).reduce((s, s2) -> String.format("%s, %s", s, s2)).orElse("");
    }
}
