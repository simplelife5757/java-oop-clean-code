package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy<Integer> {
    Random random = new Random();
    @Override
    public Integer nextPosition(Integer currentPosition) {
        int randomInt = random.ints(0, 10).findFirst().getAsInt();
        if (randomInt >= 4) {
            return currentPosition + 1;
        } else {
            return currentPosition;
        }
    }

    @Override
    public Integer initialPosition() {
        return 0;
    }
}
