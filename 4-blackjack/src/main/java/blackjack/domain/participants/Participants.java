package blackjack.domain.participants;

import blackjack.controller.dto.CardsSnapshot;
import blackjack.domain.deck.Deck;
import blackjack.domain.FinalResult;
import blackjack.domain.cards.Cards;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants {
    private final Participant dealer = new Dealer("딜러");
    private final List<Participant> players;

    public Participants(List<String> playerNames) {
        this.players = createPlayer(playerNames);
    }

    private List<Participant> createPlayer(List<String> playerNames) {
        return playerNames.stream().map(playerName -> (Participant) new Player(playerName)).collect(Collectors.toList());
    }

    private List<Participant> getAllParticipants() {
        return Stream.of(List.of(dealer), players)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public void initCard(Deck deck) {
        getAllParticipants().forEach(
                participant -> participant.receiveCards(new Cards(deck.pickRandomCards(2)))
        );
    }

    public List<CardsSnapshot> getCardSnapShots() {
        return getAllParticipants().stream().map(
                participant -> new CardsSnapshot(participant.getName(), participant.getCards())
        ).collect(Collectors.toList());
    }

    public void giveAdditionalCard(InputView inputView, OutputView outputView, Deck deck) {
        getAllParticipants().stream()
                .filter(participant -> participant.canReceiveAdditionalCard(inputView))
                .forEach(participant -> {
                    participant.receiveCards(new Cards(deck.pickRandomCards(2)));
                    outputView.outputCardSnapshot(new CardsSnapshot(participant.getName(), participant.getCards()));
                });
    }

    public List<FinalResult> getFinalResults() {
        return getAllParticipants().stream().map(
                participant -> new FinalResult(participant.getName(), participant.getWinningCount(), participant.getLosingCount())
        ).collect(Collectors.toList());
    }


    public void recordFinalResults() {
        this.players.forEach(this::recordResult);
    }

    private void recordResult(Participant participant) {
        if (participant.getScore() < this.dealer.getScore()) {
            this.dealer.win();
            participant.lose();
            return;
        }

        participant.win();
        this.dealer.lose();
    }
}

