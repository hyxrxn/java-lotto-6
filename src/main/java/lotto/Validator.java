package lotto;

import java.util.*;

public class Validator {

    public static final int PRICE_OF_LOTTO = 1000;

    void checkPurchaseAmount(String input) {
        checkNaturalNumber(input);
        checkMultiple(input);
    }

    void checkNaturalNumber(String input) {
        checkInteger(input);
        int modifiedInput = Integer.parseInt(input);
        if (modifiedInput < 1) {
            throw new IllegalArgumentException("[ERROR] 자연수가 아닙니다.");
        }
    }

    void checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수가 아닙니다.");
        }
    }

    void checkMultiple(String input) {
        int modifiedInput = Integer.parseInt(input);
        if (modifiedInput % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] " + PRICE_OF_LOTTO + "의 배수가 아닙니다.");
        }
    }

    void checkWinningNumbers(String input) {
        String[] parsedInput = input.split(",");
        checkCount(parsedInput);
        for (String winningNumber : parsedInput) {
            checkNaturalNumber(winningNumber);
            checkRange(winningNumber);
        }
        checkDuplicate(parsedInput);
    }

    void checkCount(String[] input) {
        if (input.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    void checkRange(String input) {
        int modifiedInput = Integer.parseInt(input);
        if (modifiedInput < 1 || modifiedInput > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    void checkDuplicate(String[] input) {
        List<String> list = Arrays.asList(input);
        Set<String> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
