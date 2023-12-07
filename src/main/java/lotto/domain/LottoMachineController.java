package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachineController {
    private final InputView input;
    private final OutputView output;

    public LottoMachineController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }
    public List<Lotto> execute(long money) {
        Payment payment = new Payment(money);
        LottoMachine lottoMachine = new LottoMachine();

        System.out.println(payment.countLotto(money) + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < payment.countLotto(money); i++) {
            Lotto lotto = lottoMachine.generate();
            List<Integer> numbers = lotto.getNumbers();
            output.printLottoNumbers(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
