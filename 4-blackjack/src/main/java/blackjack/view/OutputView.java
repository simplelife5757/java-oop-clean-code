package blackjack.view;

import blackjack.domain.CardSnapshot;

import java.util.List;

public class OutputView {
    public static void printCardSnapshots(List<CardSnapshot> cardSnapshots) {
        cardSnapshots.forEach(OutputView::printCardSnapshot);
    }

    public static void printCardSnapshot(CardSnapshot cardSnapshot) {
        System.out.printf("%s: %s\n", cardSnapshot.getName(), String.join(", ", cardSnapshot.getCards()));
    }
}
