package lotto.domain;

import java.util.List;

public class WinningNumbers {
    public List<Integer> applyLottoRules(List<Integer> numbers) {
        final Lotto lotto = new Lotto(numbers);
        return lotto.getNumbers();
    }
}
