package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.domain.Payment;

public class Application {
    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();

        validate(inputMoney);
        long money = Integer.parseInt(inputMoney);
        Payment payment = new Payment(money);


    }

    private static void validate(String inputMoney) {
        if (inputMoney.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        Matcher matcher = pattern.matcher(inputMoney);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
