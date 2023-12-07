package lotto.domain;

import java.util.List;

public class BonusNumber {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    public int validate(int bonusNumber, List<Integer> winningNumbers) {
        ensureRangeOfNumber(bonusNumber);
        ensureDifferentFromWinningNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private void ensureRangeOfNumber(int bonusNumber) {
        if (bonusNumber < MINIMUM || bonusNumber > MAXIMUM) {
            throw new IllegalArgumentException();
        }
    }

    private void ensureDifferentFromWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
