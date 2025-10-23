package racingcar.view;

public class ConsoleOutputView implements OutputView {

    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
