package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> createCars(List<String> carNames, MoveStrategy<Integer> moveStrategy) {
        return carNames.stream()
                .map(carName -> new Car(carName, moveStrategy))
                .collect(Collectors.toList());
    }
}
