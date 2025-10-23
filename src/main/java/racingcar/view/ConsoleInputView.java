package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleInputView implements InputView {

    @Override
    public List<String> getCarNames() {

        String input = Console.readLine();

        //Todo: 자동차 이름 검증
        List<String> carNames = List.of(input.split(","));

        return carNames;
    }

    @Override
    public int getTryCount() {

        String input = Console.readLine();

        //Todo: 시도 횟수 검증
        int count = Integer.parseInt(input);

        return count;
    }
}
