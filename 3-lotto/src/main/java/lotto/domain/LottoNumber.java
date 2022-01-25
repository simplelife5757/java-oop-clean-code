package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(String lottoNumber) {
        try {
            this.lottoNumber = Integer.parseInt(lottoNumber);
            validate(this.lottoNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또넘버는 숫자여야 합니다.");
        }
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < FIRST_NUMBER || LAST_NUMBER < lottoNumber) {
            throw new IllegalArgumentException("로또넘버는 1부터 45까지 가능합니더");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
