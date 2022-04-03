package blackjack.view;

import blackjack.controller.dto.CardsSnapshot;
import blackjack.domain.FinalResult;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    private void print(String content) {
        System.out.println(content);
    }

    @Override
    public void outputCardSnapshots(List<CardsSnapshot> cardsSnapshots) {
        cardsSnapshots.forEach(this::outputCardSnapshot);
    }

    @Override
    public void outputCardSnapshot(CardsSnapshot cardsSnapshot) {
        print(String.format("%s: %s\n", cardsSnapshot.getName(), String.join(", ", cardsSnapshot.getCardNames())));
    }

    @Override
    public void outputCardResults(List<CardsSnapshot> cardsSnapshots) {
        cardsSnapshots.forEach(this::outputCardResult);
    }

    @Override
    public void outputCardResult(CardsSnapshot cardsSnapshot) {
        print(String.format("%s: %s - 결과: %s\n", cardsSnapshot.getName(), String.join(", ", cardsSnapshot.getCardNames()), cardsSnapshot.getCardsScore()));
    }

    @Override
    public void outputFinalResults(List<FinalResult> finalResults) {
        print("## 최종 승패");
        finalResults.forEach(System.out::println);
    }
}
