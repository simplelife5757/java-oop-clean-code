package racingcar;

import java.util.List;

public class RacingCarGame {
    private final List<Car> cars;

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
