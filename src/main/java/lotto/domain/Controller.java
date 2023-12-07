package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    private final InputView input;
    private final OutputView output;

    public Controller(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        InputProcessor processor = new InputProcessor(input);
        long money = processor.processInputOfMoney();

        LottoMachineController lottoMachineController = new LottoMachineController(input, output);
        List<Lotto> lottos = lottoMachineController.execute(money);

        List<Integer> winningNumbers = processor.processInputOfWinningNumbers();
        int bonusNumber = processor.processInputOfBonusNumber(winningNumbers);

        LottoMarker lottoMarker = new LottoMarker();
        Map<Integer, Integer> winningTable = lottoMarker.makeWinningTable(lottos, winningNumbers, bonusNumber);

    }
    private void validate(String inputMoney) {
        if (inputMoney.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        Matcher matcher = pattern.matcher(inputMoney);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
