package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.Test;

class LottoMachineControllerTest {
    @Test
    void name() {
        // Given
        InputView input = new InputView();
        OutputView output = new OutputView();
        LottoMachineController lottoMachineController = new LottoMachineController(input, output);

        // When
        List<Lotto> lottos = lottoMachineController.execute(4000);

        // Then
        assertThat(lottos.size()).isEqualTo(4);
    }
}