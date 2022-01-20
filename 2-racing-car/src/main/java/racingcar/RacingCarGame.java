package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final List<Car> cars;
    private final List<RoundSnapShot> roundSnapShots = new ArrayList<>();

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void recordRoundSnapShot() {
        Integer currentRound = roundSnapShots.size() + 1;
        roundSnapShots.add(
                new RoundSnapShot(
                        currentRound,
                        cars.stream().map(Car::snapShot).collect(Collectors.toList())
                )
        );
    }

    public List<RoundSnapShot> getRoundSnapShots() {
        return roundSnapShots;
    }
}
