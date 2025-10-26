package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    void 자동차_전진_임계값이상(int input) {
        Car car = new Car("car");
        int cur = car.getPosition();

        car.move(input);

        assertThat(car.getPosition()).isEqualTo(cur + 1);

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void 자동차_전진_임계값미만(int input) {
        Car car = new Car("car");
        int cur = car.getPosition();

        car.move(input);

        assertThat(car.getPosition()).isEqualTo(cur);
    }
}
