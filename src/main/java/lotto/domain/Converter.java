package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public List<String> splitByComma(String inputWinningNumbers) {
        return Arrays.asList(inputWinningNumbers.split(","));
    }

    public List<Integer> convertToWinningNumbers(List<String> splitInput) {
        return splitInput.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public long convertToMoney(String inputMoney) {
        return Long.parseLong(inputMoney);
    }

    public int convertToBonusNumber(String inputBonusNumber) {
        return Integer.parseInt(inputBonusNumber);
    }
}
