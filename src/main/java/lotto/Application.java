package lotto;

import lotto.domain.Controller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        OutputView output = new OutputView();

        Controller controller = new Controller(input, output);
        controller.start();
    }
}
