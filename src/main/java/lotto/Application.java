package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.domain.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;
import lotto.domain.PrizeChecker;
import lotto.domain.WinningNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Money money = new Money(askToPay());// 금액 입력
        long howManyLotto = money.getHowManyLotto();// 로또 개수

        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = generator.generateLotto(howManyLotto);

        List<Integer> winningNumber = askWinningNumber();// 당첨번호 6개 입력
        int bonusNumber = askBonus();// 보너스번호 입력
        WinningNumber numbers = new WinningNumber(winningNumber, bonusNumber);
        PrizeChecker checker = new PrizeChecker();
        Map<Integer, Integer> winningByRank = checker.recordWinningByRank(
                lottos, numbers.getWinningNumber(), numbers.getBonusNumber());

        // 당첨내역 출력
        // 수익률 출력
        // 게임 종료
    }

    public static long askToPay() {
        System.out.println("구입 금액을 입력해주세요.");
        InputConverter converter = new InputConverter();
        return converter.convertToMoney(Console.readLine());
    }

    public static List<Integer> askWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요. (숫자 6개 입력)");
        InputConverter converter = new InputConverter();
        return converter.convertToWinningNumbers(Console.readLine());
    }

    public static int askBonus() {
        System.out.println("보너스 번호를 입력해주세요.");
        InputConverter converter = new InputConverter();
        return converter.convertToBonusNumber(Console.readLine());
    }
}
