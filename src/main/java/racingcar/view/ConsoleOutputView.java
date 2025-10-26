package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class ConsoleOutputView implements OutputView {

    private static final String POSITION_INDICATOR = "-";
    private static final String NAME_DELIMITER = " : ";

    @Override
    public void printMessage(String output) {
        System.out.println(output);
    }

    @Override
    public void printRoundResult(List<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getName() + NAME_DELIMITER);
            for(int i = 0; i < car.getPosition(); i++) {
                System.out.print(POSITION_INDICATOR);
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();

        String output = String.join(", ", winnerNames);

        System.out.print(GameMessage.WINNER_MESSAGE);
        System.out.println(output);
    }
}
