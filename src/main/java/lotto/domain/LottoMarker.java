package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMarker {
    public Map<Integer, Integer> makeWinningTable(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> winningTable = makeInitialTable();
        for (Lotto lotto : lottos) {
            long count = countMatchingNumbers(winningNumbers, lotto);
            if (count == 5) {
                checkBonusNumber(lotto, bonusNumber, winningTable);
            }
            recordWinningCase(count, winningTable);
        }
        return winningTable;
    }

    private static long countMatchingNumbers(List<Integer> winningNumbers, Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private Map<Integer, Integer> makeInitialTable() {
        Map<Integer, Integer> initialTable = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            initialTable.put(i, 0);
        }
        return initialTable;
    }

    private void recordWinningCase(long count, Map<Integer, Integer> winningTable) {
        if (count == 3) {
            winningTable.put(5, winningTable.get(5) + 1);
        }
        if (count == 4) {
            winningTable.put(4, winningTable.get(4) + 1);
        }
        if (count == 6) {
            winningTable.put(1, winningTable.get(1) + 1);
        }
    }

    private void checkBonusNumber(Lotto lotto, int bonusNumber, Map<Integer, Integer> winningTable) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            winningTable.put(2, winningTable.get(2) + 1);
        }
        if (!lotto.getNumbers().contains(bonusNumber)) {
            winningTable.put(3, winningTable.get(3) + 1);
        }
    }
}
