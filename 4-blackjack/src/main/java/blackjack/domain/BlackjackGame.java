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
}
