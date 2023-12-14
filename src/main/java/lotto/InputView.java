package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    Validator validator = new Validator();
    int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println(REQUEST_PURCHASE_AMOUNT);
                String purchaseAmount = Console.readLine();
                validator.checkPurchaseAmount(purchaseAmount);
                System.out.println();
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println(REQUEST_WINNING_NUMBERS);
                String winningNumbers = Console.readLine();
                validator.checkWinningNumbers(winningNumbers);
                System.out.println();
                return Arrays.stream(winningNumbers.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println(REQUEST_BONUS_NUMBER);
                String bonusNumber = Console.readLine();
                validator.checkBonusNumber(bonusNumber, winningNumbers);
                return Integer.parseInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
