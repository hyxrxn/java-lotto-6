package lotto;

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
}
