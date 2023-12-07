package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @Test
    void name() {
        // Given
        LottoMachine lottoMachine = new LottoMachine();

        // When
        List<Lotto> lottos = lottoMachine.generate(4000);

        // Then
        assertThat(lottos.size()).isEqualTo(4);
    }
}