package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.exception.ErrorReason;

public class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자 초과인 경우 예외 처리")
    void 자동차_이름_길이초과_테스트() {
        List<String> carNames = List.of("pobiii", "javaji");

        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorReason.CAR_NAME_TOO_LONG.getMessage());

    }

    @Test
    @DisplayName("자동차 이름이 비어있는 경우 예외 처리")
    void 자동차_이름_공백_테스트() {
        List<String> carNames = List.of("");

        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorReason.EMPTY_CAR_NAME.getMessage());

    }

    @Test
    @DisplayName("자동차 이름이 공백으로 이루어진 경우 예외 처리")
    void 자동차_이름_공백_테스트2() {
        List<String> carNames = List.of("   ");

        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorReason.EMPTY_CAR_NAME.getMessage());

    }

    @Test
    @DisplayName("시도횟수가 숫자가 아닌 경우 예외 처리")
    void 시도횟수_형식_테스트() {
        String input = "one";

        assertThatThrownBy(() -> InputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorReason.TRY_COUNT_NOT_NUMBER.getMessage());

    }

    @Test
    @DisplayName("시도횟수가 0인 경우 예외 처리")
    void 시도횟수_크기_테스트() {
        String input = "0";

        assertThatThrownBy(() -> InputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorReason.TRY_COUNT_TOO_SMALL.getMessage());

    }

    @Test
    @DisplayName("시도횟수가 음수인 경우 예외 처리")
    void 시도횟수_크기_테스트2() {
        String input = "-1";

        assertThatThrownBy(() -> InputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorReason.TRY_COUNT_TOO_SMALL.getMessage());

    }
}
