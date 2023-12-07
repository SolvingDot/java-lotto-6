package lotto.domain;

public class Payment {
    private static final long MINIMUM_UNIT = 1_000;
    private static final long NO_REMAINDER = 0;

    private final long money;

    public Payment(long money) {
        validate(money);
        this.money = money;
    }

    public long countLotto(long money) {
        return money / MINIMUM_UNIT;
    }

    private void validate(long money) {
        if (money < MINIMUM_UNIT) {
            throw new IllegalArgumentException("최소 금액은 1000원입니다.");
        }
        if (money % MINIMUM_UNIT != NO_REMAINDER) {
            throw new IllegalArgumentException("1000단위로 입력해주세요.");
        }
    }
}
