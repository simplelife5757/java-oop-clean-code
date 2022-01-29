package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGeneratorStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequentialLottoTicketGeneratorStrategy implements LottoTicketGeneratorStrategy {
    private int offset = 1;
    public static final int LOTTO_TICKET_SIZE = 6;

    @Override
    public LottoTicket generate() {
        IntStream.of(6).boxed().collect(Collectors.toList());

        List<LottoNumber> lottoNumbers = Stream.iterate(this.offset, n -> n + 1).map(number -> new LottoNumber(String.valueOf(number))).limit(LOTTO_TICKET_SIZE).collect(Collectors.toList());
        this.offset = this.offset + LOTTO_TICKET_SIZE;

        return new LottoTicket(lottoNumbers);
    }
}
