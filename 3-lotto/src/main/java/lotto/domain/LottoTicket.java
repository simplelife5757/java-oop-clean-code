package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(String lottoTicket) {
        try {
            this.lottoNumbers = Arrays.stream(lottoTicket.split(", ")).map(LottoNumber::new).collect(Collectors.toList());
            validate(this.lottoNumbers);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("로또넘버는 ,로 구분되어 있어야 합니다.");
        }
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또티켓은 6개의 로또넘버로 구성되어 있습니다.");
        }
        if (lottoNumbers.stream().collect(Collectors.toSet()).size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또티켓은 6개의 서로 다른 로또넘버로 구성되어 있습니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.stream().map(lottoNumber -> String.valueOf(lottoNumber.getLottoNumber())).collect(Collectors.joining(", ")));
    }

    public int countWinningNumber(LottoTicket lottoTicket) {
        return (int) this.lottoNumbers.stream().map(lottoTicket::contain).filter(p -> p).count();
    }

    public boolean contain(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }
}
