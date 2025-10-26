package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import racingcar.validator.exception.ErrorReason;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        validateCarNameDuplicate(carNames);
        validateCarNameLength(carNames);
    }

    public static void validateCarNameLength(List<String> carNames) {
        for(String carName : carNames) {
            if(carName == null || carName.isBlank()) {
                throw new IllegalArgumentException(ErrorReason.EMPTY_CAR_NAME.getMessage());
            }
            if(carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorReason.CAR_NAME_TOO_LONG.getMessage());
            }
        }
    }

    public static void validateCarNameDuplicate(List<String> carNames) {
        if(carNames.size() != new HashSet<String>(carNames).size()){
            throw new IllegalArgumentException(ErrorReason.DUPLICATED_CAR_NAME.getMessage());
        }
    }

    public static int validateTryCount(String input) {
        try {
            int tryCount = Integer.parseInt(input);
            if(tryCount <= 0) {
                throw new IllegalArgumentException(ErrorReason.TRY_COUNT_TOO_SMALL.getMessage());
            }

            return tryCount;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorReason.TRY_COUNT_NOT_NUMBER.getMessage());
        }
    }

}
