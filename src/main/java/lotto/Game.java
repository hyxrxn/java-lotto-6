package lotto;

import java.util.List;
import java.util.Map;

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
        calculateResult();
    }

    void makeLottos() {
        purchaseAmount = inputView.readPurchaseAmount();
        int purchaseCount = purchaseAmount / PRICE_OR_LOTTO;
        lottos = new Lottos(purchaseCount);
        outputView.showLottos(purchaseCount, lottos);
    }

    void getWinningInformation() {
        winningNumbers = inputView.readWinningNumbers();
        bonusNumber = inputView.readBonusNumber(winningNumbers);
    }

    void calculateResult() {
        Map<Rank, Integer> rankCounts = lottos.calculateResult(winningNumbers, bonusNumber);
        long prize = 0;
        for (Rank rank : Rank.values()) {
            int count = rankCounts.getOrDefault(rank, 0);
            prize += (long) count * rank.getPrizeMoney();
        }
        double rateOfReturn = (double) prize / purchaseAmount * 100;
        outputView.showResult(rankCounts, rateOfReturn);
    }
}
