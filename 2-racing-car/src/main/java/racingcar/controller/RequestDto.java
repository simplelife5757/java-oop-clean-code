package racingcar.controller;

import java.util.List;

public class RequestDto {
    private List<String> carNames;
    private Integer round;

    public RequestDto(List<String> carNames, Integer round) {
        this.carNames = carNames;
        this.round = round;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Integer getRound() {
        return round;
    }
}
