package racingcar;

import java.util.List;

public class RoundSnapShot {
    private final Integer round;
    private final List<CarSnapShot> carSnapShots;

    public RoundSnapShot(Integer round, List<CarSnapShot> carSnapShots) {
        this.round = round;
        this.carSnapShots = carSnapShots;
    }

    public Integer getRound() {
        return round;
    }

    public List<CarSnapShot> getCarSnapShots() {
        return carSnapShots;
    }
}
