package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(String lottoTicket) {
        try {
            this.lottoNumbers = Arrays.stream(lottoTicket.split(",")).map(LottoNumber::new).collect(Collectors.toList());
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
}
