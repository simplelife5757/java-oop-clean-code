package racingcar;

import java.util.Objects;

public class CarSnapShot {
    private Integer position;

    public CarSnapShot(Integer position) {
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarSnapShot that = (CarSnapShot) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
