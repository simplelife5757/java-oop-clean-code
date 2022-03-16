package blackjack.view;

import blackjack.domain.CardSnapshot;
import blackjack.domain.FinalResult;

import java.util.List;

public class OutputView {
    public static void printCardSnapshots(List<CardSnapshot> cardSnapshots) {
        cardSnapshots.forEach(OutputView::printCardSnapshot);
    }

    public static void printCardSnapshot(CardSnapshot cardSnapshot) {
        System.out.printf("%s: %s\n", cardSnapshot.getName(), String.join(", ", cardSnapshot.getCards()));
    }

    public static void printCardResults(List<CardSnapshot> cardSnapshots) {
        cardSnapshots.forEach(OutputView::printCardResult);
    }

    public static void printCardResult(CardSnapshot cardSnapshot) {
        System.out.printf("%s: %s - 결과: %s\n", cardSnapshot.getName(), String.join(", ", cardSnapshot.getCards()), 10);
    }

    public static void printFinalResults(List<FinalResult> finalResults) {
        System.out.println("## 최종 승패");
        finalResults.forEach(System.out::println);
    }
}
