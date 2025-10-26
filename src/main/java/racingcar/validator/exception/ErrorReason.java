package racingcar.validator.exception;

public enum ErrorReason {

    //자동차 이름 관련 에러
    CAR_NAME_TOO_LONG("자동차 이름은 5자를 초과할 수 없습니다."),
    EMPTY_CAR_NAME("자동차 이름은 비어있을 수 없습니다."),
    DUPLICATED_CAR_NAME("자동차 이름은 중복될 수 없습니다."),

    //시도 횟수 관련 에러
    TRY_COUNT_TOO_SMALL("시도 횟수는 1이상이어야 합니다."),
    TRY_COUNT_NOT_NUMBER("시도 횟수는 숫자만 입력할 수 있습니다.");

    private final String message;

    ErrorReason(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
