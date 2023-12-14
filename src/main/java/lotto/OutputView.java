package lotto;

import java.util.Map;

public class OutputView {
    void showLottos(int purchaseNumber, Lottos lottos) {
        System.out.println();
        System.out.println(purchaseNumber + "개를 구매했습니다.");
        lottos.printLottos();
        System.out.println();
    }

    void showResult(Map<Rank, Integer> rankCounts, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            int count = rankCounts.getOrDefault(rank, 0);
            System.out.println(rank.getDescription() + " - " + count + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}
