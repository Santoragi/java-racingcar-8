package racingcar.model.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
