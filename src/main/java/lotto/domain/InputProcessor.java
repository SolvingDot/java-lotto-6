package lotto.domain;

import java.util.List;
import lotto.view.InputView;

public class InputProcessor {
    final Validator validator = new Validator();
    final Converter converter = new Converter();

    private final InputView input;

    public InputProcessor(InputView input) {
        this.input = input;
    }

    public long processInputOfMoney() {
        String inputMoney = input.askToPay();
        validator.ensureHasAnyValue(inputMoney);
        validator.ensureOnlyNumeric(inputMoney);
        long money = converter.convertToMoney(inputMoney);
        Payment payment = new Payment(money);
        return payment.getMoney();
    }

    public List<Integer> processInputOfWinningNumbers() {
        List<String> splitNumbers = converter.splitByComma(input.askWinningNumbers());
        splitNumbers.forEach(numbers -> {
            validator.ensureHasAnyValue(numbers);
            validator.ensureOnlyNumeric(numbers);
        });
        List<Integer> numbers = converter.convertToWinningNumbers(splitNumbers);
        final WinningNumbers winningNumbers = new WinningNumbers();
        return winningNumbers.applyLottoRules(numbers);
    }

    public int processInputOfBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber = input.askBonusNumber();
        validator.ensureHasAnyValue(inputBonusNumber);
        validator.ensureOnlyNumeric(inputBonusNumber);
        int number = converter.convertToBonusNumber(inputBonusNumber);
        final BonusNumber bonusNumber = new BonusNumber();
        return bonusNumber.validate(number, winningNumbers);
    }
}
