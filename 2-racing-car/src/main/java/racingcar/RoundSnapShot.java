package racingcar;

import java.util.List;

public class RoundSnapShot {
    private final Integer round;
    private final List<CarSnapShot> carSnapShotList;

    public RoundSnapShot(Integer round, List<CarSnapShot> carSnapShotList) {
        this.round = round;
        this.carSnapShotList = carSnapShotList;
    }

    public Integer getRound() {
        return round;
    }

    public List<CarSnapShot> getCarSnapShotList() {
        return carSnapShotList;
    }
}
