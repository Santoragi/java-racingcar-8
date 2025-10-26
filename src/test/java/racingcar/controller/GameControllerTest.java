package racingcar.controller;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class GameControllerTest {

    @Test
    @DisplayName("차 이름 리스트를 통해 Car 객체 생성 테스트")
    void 자동차_생성_테스트() {
        GameController gameController = new GameController(null, null);
        List<String> carNames = List.of("car1", "car2", "car3");

        List<Car> cars = gameController.createCars(carNames);

        assertThat(cars).hasSize(3);
        assertThat(cars)
                .extracting(Car::getName)
                .containsExactly("car1", "car2", "car3");
    }
}
