package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoTicketGeneratorStrategy implements LottoTicketGeneratorStrategy {
    private static final List<Integer> lottoNumberPool = IntStream.iterate(1, value -> value + 1).boxed().limit(45).collect(Collectors.toList());
    @Override
    public LottoTicket generate() {
        Collections.shuffle(lottoNumberPool);
        return new LottoTicket(lottoNumberPool.stream()
                .map(value -> new LottoNumber(String.valueOf(value)))
                .limit(6)
                .sorted()
                .collect(Collectors.toList())
        );
    }
}
