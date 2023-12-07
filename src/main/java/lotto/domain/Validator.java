package lotto.domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    public void ensureHasAnyValue(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public void ensureOnlyNumeric(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public void ensureRangeOfNumber(int bonusNumber) {
        if (bonusNumber < MINIMUM || bonusNumber > MAXIMUM) {
            throw new IllegalArgumentException();
        }
    }

    public void ensureDifferentFromWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
