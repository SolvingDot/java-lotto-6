package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.WinningDetails;

public class OutputView {
    public void printLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public void printWinningDetails(Map<Integer, Integer> winningTable) {
        System.out.printf(OutputMessage.FIFTH, winningTable.get(WinningDetails.FIFTH_PLACE.getRank()));
        System.out.printf(OutputMessage.FOURTH, winningTable.get(WinningDetails.FOURTH_PLACE.getRank()));
        System.out.printf(OutputMessage.THIRD, winningTable.get(WinningDetails.THIRD_PLACE.getRank()));
        System.out.printf(OutputMessage.SECOND, winningTable.get(WinningDetails.SECOND_PLACE.getRank()));
        System.out.printf(OutputMessage.FIRST, winningTable.get(WinningDetails.FIRST_PLACE.getRank()));
    }
}
