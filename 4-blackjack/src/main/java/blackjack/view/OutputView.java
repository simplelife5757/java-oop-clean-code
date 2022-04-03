package blackjack.view;

import blackjack.controller.dto.CardsSnapshot;
import blackjack.domain.FinalResult;

import java.util.List;

public interface OutputView {
    public void outputCardSnapshots(List<CardsSnapshot> cardsSnapshots);

    public void outputCardSnapshot(CardsSnapshot cardsSnapshot);

    public void outputCardResults(List<CardsSnapshot> cardsSnapshots);

    public void outputCardResult(CardsSnapshot cardsSnapshot);

    public void outputFinalResults(List<FinalResult> finalResults);
}
