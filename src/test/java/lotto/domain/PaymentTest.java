package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaymentTest {
    @Test
    void 최소금액() {
        assertThatThrownBy(() -> new Payment(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액단위() {
        assertThatThrownBy(() -> new Payment(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}