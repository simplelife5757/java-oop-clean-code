package racingcar;

import java.util.List;

public class RequestDto {
    private List<String> carNames;
    private int round;

    public RequestDto(List<String> carNames, int round) {
        this.carNames = carNames;
        this.round = round;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getRound() {
        return round;
    }
}
