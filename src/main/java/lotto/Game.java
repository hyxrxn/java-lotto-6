package lotto;

import java.util.List;

public class Game {
    public static final int PRICE_OR_LOTTO = 1000;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Lottos lottos;
    int purchaseAmount;
    List<Integer> winningNumbers;
    int bonusNumber;

    void play() {
        makeLottos();
        getWinningInformation();
    }

    void makeLottos() {
        purchaseAmount = inputView.readPurchaseAmount() / PRICE_OR_LOTTO;
        lottos = new Lottos(purchaseAmount);
        outputView.showLottos(purchaseAmount, lottos);
    }

    void getWinningInformation() {
        winningNumbers = inputView.readWinningNumbers();
        bonusNumber = inputView.readBonusNumber(winningNumbers);
    }
}
