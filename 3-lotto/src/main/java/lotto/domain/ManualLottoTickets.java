package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoTickets {
    private List<LottoTicket> manualLottoTicket;

    public ManualLottoTickets(List<String> manualLottoTickets) {
        this.manualLottoTicket = manualLottoTickets.stream().map(LottoTicket::new).collect(Collectors.toList());
    }
}
