package blackjack.domain.participants;


import blackjack.view.InputView;

public class Dealer extends Participant {

    public Dealer(String name) {
        super(name);
    }

    @Override
    public boolean canReceiveAdditionalCard(InputView inputView) {
        return this.getScore() < 16;
    }
}

