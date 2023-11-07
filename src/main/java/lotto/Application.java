package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Yield;
import lotto.ui.Input;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;
import lotto.domain.PrizeChecker;
import lotto.domain.WinningNumber;
import lotto.ui.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Money money = new Money(input.askToPay());// 금액 입력
        long howManyLotto = money.getHowManyLotto();// 로또 개수

        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = generator.generateLotto(howManyLotto);
        Output output = new Output();
        output.printLotto(howManyLotto, lottos);

        WinningNumber numbers = new WinningNumber(input.askWinningNumber(), input.askBonus());
        PrizeChecker checker = new PrizeChecker();
        Map<Integer, Integer> winningByRank = checker.recordWinningByRank(
                lottos, numbers.getWinningNumber(), numbers.getBonusNumber());
        output.printWinning(winningByRank);

        Yield yield = new Yield();
        long totalPrizeMoney = yield.sumPrizeMoney(winningByRank);
        double rateOfReturn = yield.calculate(totalPrizeMoney, money.getMoney());
        output.printYeild(rateOfReturn);
        // 게임 종료
    }
}
