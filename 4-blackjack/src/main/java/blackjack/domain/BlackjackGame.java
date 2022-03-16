package blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BlackjackGame {
    private final Dealer dealer = new Dealer();
    private final List<Player> players;
    private final Deck deck;

    public BlackjackGame(List<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    public void giveOutCards() {
        dealer.receiveCards(new Cards(deck.pickRandomCards(2)));
        players.forEach(player -> player.receiveCards(new Cards(deck.pickRandomCards(2))));
    }

    public List<CardSnapshot> getCardSnapshots() {
        List<CardSnapshot> cardSnapshots = new ArrayList<>();
        cardSnapshots.add(new CardSnapshot(dealer.getName(), dealer.getCardNames()));
        cardSnapshots.addAll(
                players.stream()
                        .map(player -> new CardSnapshot(player.getName(), player.getCardNames()))
                        .collect(Collectors.toList())
        );
        return cardSnapshots;
    }

    // TODO: 함수명 변경
    public boolean canReceiveAdditionalCard(String playerName) {
        Player player = findPlayer(playerName);
        return player.getScore() < 21;
    }

    private Player findPlayer(String playerName) {
        return players.stream().filter(player -> Objects.equals(player.getName(), playerName)).findFirst().orElseThrow(IllegalAccessError::new);
    }

    public void giveAdditionalCard(String playerName) {
        Player player = findPlayer(playerName);
        player.receiveCards(new Cards(deck.pickRandomCards(1)));
    }

    public CardSnapshot getCardSnapshot(String playerName) {
        Player player = findPlayer(playerName);
        return new CardSnapshot(player.getName(), player.getCardNames());
    }

    public void giveAdditionalCardToDealer() {
        while (dealer.getScore() < 16) {
            dealer.receiveCards(new Cards(deck.pickRandomCards(1)));
        }
    }

    public List<FinalResult> getFinalResults() {
        this.players.forEach(player -> recordResult(player, dealer));

        List<FinalResult> finalResults = new ArrayList<>();
        FinalResult dealerResult = new FinalResult(dealer.getName(), dealer.getRecord().getWinningCount(), dealer.getRecord().getLosingCount());
        finalResults.add(dealerResult);
        List<FinalResult> playerResults = players.stream().map(player -> new FinalResult(player.getName(), player.getRecord().getWinningCount(), player.getRecord().getLosingCount())).collect(Collectors.toList());
        finalResults.addAll(playerResults);

        return finalResults;
    }

    private void recordResult(Player player, Dealer dealer) {
        if (player.getScore() < dealer.getScore()) {
            dealer.win();
            player.lose();
            return;
        }

        dealer.lose();
        player.win();
    }
}
