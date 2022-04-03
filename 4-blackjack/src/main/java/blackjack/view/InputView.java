package blackjack.view;

import java.util.List;

public interface InputView {
    public List<String> inputPlayerNames();

    public boolean askOneMoreCard(String playerName);
}
