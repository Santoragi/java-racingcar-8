package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.generator.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public GameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void runRacingGame() {
        List<String> carNames = inputView.getCarNames();
        List<Car> cars = createCars(carNames);

        int tryCount = inputView.getTryCount();
        for(int i = 0; i < tryCount; i++) {
            moveAll(cars);
        }
    }

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public void moveAll(List<Car> cars) {
        for(Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }
}
