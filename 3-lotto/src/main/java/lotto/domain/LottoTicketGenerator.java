package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketGenerator {
    public LottoTicketGenerator() {
    }

    public List<LottoTicket> generateManualLottoTickets(List<String> manualLottoTickets) {
        return manualLottoTickets.stream().map(LottoTicket::new).collect(Collectors.toList());
    }

    public List<LottoTicket> generateAutoLottoTickets(LottoTicketGeneratorStrategy lottoTicketGeneratorStrategy, int size) {
        return Stream.generate(lottoTicketGeneratorStrategy::generate).limit(size).collect(Collectors.toList());
    }
}
