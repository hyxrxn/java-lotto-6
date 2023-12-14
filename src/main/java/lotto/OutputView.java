package lotto;

public class OutputView {
    void showLottos(int purchaseNumber, Lottos lottos) {
        System.out.println();
        System.out.println(purchaseNumber + "개를 구매했습니다.");
        lottos.printLottos();
        System.out.println();
    }
}
