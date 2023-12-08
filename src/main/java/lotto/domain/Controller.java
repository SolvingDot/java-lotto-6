package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import lotto.view.InputView;
import lotto.view.OutputMessage;
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

        LottoMachineController lottoMachineController = new LottoMachineController(output);
        List<Lotto> lottos = lottoMachineController.execute(money);

        List<Integer> winningNumbers = processor.processInputOfWinningNumbers();
        int bonusNumber = processor.processInputOfBonusNumber(winningNumbers);

        LottoMarker lottoMarker = new LottoMarker();
        Map<Integer, Integer> winningTable = lottoMarker.makeWinningTable(lottos, winningNumbers, bonusNumber);

        output.printWinningDetails(winningTable);
    }
}
