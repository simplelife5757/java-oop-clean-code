package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;

public class OutputView {
    public static void printLottoTickets(List<LottoTicket> manualLottoTickets, List<LottoTicket> autoLottoTickets) {
        System.out.println(String.format("수동으로 %s장, 자동으로 %s장을 구매했습니다.", manualLottoTickets.size(), autoLottoTickets.size()));
        manualLottoTickets.forEach(System.out::println);
        autoLottoTickets.forEach(System.out::println);
    }
}
