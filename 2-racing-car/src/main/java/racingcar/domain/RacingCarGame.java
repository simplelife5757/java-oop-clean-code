package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    private void playAndRecord() {
        play();
        recordRoundSnapShot();
    }

    public void playAndRecord(Integer round) {
        IntStream.rangeClosed(1, round).forEach(i -> playAndRecord());
    }

    public List<Car> getFinalWinners() {
        Integer winnersPosition = cars.stream().map(Car::getPosition).reduce(0, Math::max);
        return cars.stream()
                .filter(car -> Objects.equals(car.getPosition(), winnersPosition))
                .collect(Collectors.toList());
    }
}
