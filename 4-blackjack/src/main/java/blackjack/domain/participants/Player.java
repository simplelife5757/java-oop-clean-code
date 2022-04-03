package blackjack.domain.participants;


import blackjack.domain.participants.Participant;
import blackjack.view.InputView;

public class Player extends Participant {

    public Player(String name) {
        super(name);
    }

    @Override
    public boolean canReceiveAdditionalCard(InputView inputView) {
        return this.getScore() < 21 && inputView.askOneMoreCard(this.getName());
    }
}
