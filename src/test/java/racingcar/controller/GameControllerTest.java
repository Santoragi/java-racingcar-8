package racingcar.controller;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.generator.NumberGenerator;
import racingcar.model.generator.TestNumberGenerator;

public class GameControllerTest {

    @Test
    @DisplayName("차 이름 리스트를 통해 Car 객체 생성 테스트")
    void 자동차_생성_테스트() {
        GameController gameController = new GameController(null, null, null);
        List<String> carNames = List.of("car1", "car2", "car3");

        List<Car> cars = gameController.createCars(carNames);

        assertThat(cars).hasSize(3);
        assertThat(cars)
                .extracting(Car::getName)
                .containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("임계값 이상인 경우 모든 자동차가 전진")
    void 자동차_전진_테스트_임계값이상() {
        NumberGenerator numberGenerator = new TestNumberGenerator(4);
        GameController gameController = new GameController(null, null, numberGenerator);

        List<Car> cars = List.of(new Car("car1"), new Car("car2"));

        gameController.moveAll(cars);

        assertThat(cars).allSatisfy(car ->
                assertThat(car.getPosition()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("임계값 미만인 경우 모든 자동차가 전진하지 않음")
    void 자동차_전진_테스트_임계값미만() {
        NumberGenerator numberGenerator = new TestNumberGenerator(3);
        GameController gameController = new GameController(null, null, numberGenerator);

        List<Car> cars = List.of(new Car("car1"), new Car("car2"));

        gameController.moveAll(cars);

        assertThat(cars).allSatisfy(car ->
                assertThat(car.getPosition()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("주어진 자동차 리스트에서 우승자 추출")
    void 우승자_추출_테스트() {
        GameController gameController = new GameController(null, null, null);
        List<Car> cars = List.of(
                new Car("car1", 1),
                new Car("car2", 2)
        );

        List<Car> winners = gameController.getWinners(cars);

        assertThat(winners)
                .hasSize(1)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("car2");

    }

    @Test
    @DisplayName("주어진 자동차 리스트에서 공동 우승자 추출")
    void 공동_우승자_추출_테스트() {
        GameController gameController = new GameController(null, null, null);
        List<Car> cars = List.of(
                new Car("car1", 1),
                new Car("car2", 2),
                new Car("car3", 2)
        );

        List<Car> winners = gameController.getWinners(cars);

        assertThat(winners)
                .hasSize(2)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("car2", "car3");

    }
}
