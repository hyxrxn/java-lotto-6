package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int purchaseAmount) {
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    void printLottos() {
        for (Lotto lotto : lottos) {
            lotto.printlotto();
        }
    }
}
