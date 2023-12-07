package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<Lotto> generate(long money) {
        List<Lotto> lottos = new ArrayList<>();

        Payment payment = new Payment(money);
        for (int i = 0; i < payment.countLotto(money); i++) {
            Lotto lotto = new Lotto(generateNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
