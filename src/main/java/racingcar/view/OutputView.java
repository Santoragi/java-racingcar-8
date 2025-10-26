package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public interface OutputView {

    void printMessage(String output);
    void printRoundResult(List<Car> cars);
    void printWinners(List<Car> winners);
}
