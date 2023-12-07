package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
