package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int purchaseAmount) {
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(new Lotto(numbers));
        }
    }

    void printLottos() {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    Map<Rank, Integer> calculateResult(List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            int matchedNumbers = lotto.matchedNumbers(winningNumbers);
            boolean isContainBonusNumber = lotto.isContainBonusNumber(bonusNumber);
            Rank rank = Rank.findRank(matchedNumbers, isContainBonusNumber);
            if (rank != null) {
                rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
            }
        }
        return rankCounts;
    }
}
