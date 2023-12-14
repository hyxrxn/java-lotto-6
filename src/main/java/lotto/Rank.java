package lotto;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    private final int matchingNumbers;
    private final int prizeMoney;
    private final boolean bonusMatch;

    Rank(int matchingNumbers, int prizeMoney) {
        this(matchingNumbers, prizeMoney, false);
    }

    Rank(int matchingNumbers, int prizeMoney, boolean bonusMatch) {
        this.matchingNumbers = matchingNumbers;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
    }

    public static Rank findRank(int matchingNumbers, boolean bonusMatch) {
        if (matchingNumbers == SECOND.matchingNumbers && bonusMatch) {
            return SECOND;
        }
        for (Rank rank : Rank.values()) {
            if (rank != SECOND && matchingNumbers == rank.matchingNumbers) {
                return rank;
            }
        }
        return null;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public String getDescription() {
        if (this == SECOND) {
            return getMatchingNumbers() + "개 일치, 보너스 볼 일치 (" + String.format("%,d", getPrizeMoney()) + "원)";
        }
        return getMatchingNumbers() + "개 일치 (" + String.format("%,d", getPrizeMoney()) + "원)";
    }
}

