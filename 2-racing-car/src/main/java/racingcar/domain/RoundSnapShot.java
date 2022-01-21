package racingcar.domain;

import java.util.List;

public class RoundSnapShot {
    private final int round;
    private final List<CarSnapShot> carSnapShotList;

    public RoundSnapShot(int round, List<CarSnapShot> carSnapShotList) {
        this.round = round;
        this.carSnapShotList = carSnapShotList;
    }

    public int getRound() {
        return round;
    }

    public List<CarSnapShot> getCarSnapShots() {
        return carSnapShotList;
    }
}
