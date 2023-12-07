package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ensureSizeOfNumbers(numbers);
        ensureDifferentNumbers(numbers);
        ensureRangeOfNumbers(numbers);
    }

    // TODO: 추가 기능 구현
    private void ensureSizeOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void ensureDifferentNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void ensureRangeOfNumbers(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MINIMUM || number > MAXIMUM)) {
            throw new IllegalArgumentException();
        }
    }
}
