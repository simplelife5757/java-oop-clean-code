package racingcar;

import java.util.Objects;

public class CarSnapShot {
    private int position;
    private String name;

    public CarSnapShot(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarSnapShot that = (CarSnapShot) o;
        return Objects.equals(position, that.position) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
