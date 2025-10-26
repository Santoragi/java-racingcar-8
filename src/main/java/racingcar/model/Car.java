package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int random) {
        if(isMovable(random)) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }

    private boolean isMovable(int random) {
        return random >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
