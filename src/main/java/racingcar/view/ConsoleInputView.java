package racingcar.view;

import static racingcar.validator.InputValidator.validateCarNames;
import static racingcar.validator.InputValidator.validateTryCount;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleInputView implements InputView {

    @Override
    public List<String> getCarNames() {

        String input = Console.readLine();

        List<String> carNames = List.of(input.split(","));
        validateCarNames(carNames);

        return carNames;
    }

    @Override
    public int getTryCount() {

        String input = Console.readLine();
        int count = validateTryCount(input);

        return count;
    }
}
