package lotto.domain;

public class Payment {
    private final long money;

    public Payment(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        if (money < 1000) {
            throw new IllegalArgumentException("최소 금액은 1000원입니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000단위로 입력해주세요.");
        }
    }
}
