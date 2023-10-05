package music.kamilaself.top.sugar_music.exception;

import music.kamilaself.top.sugar_music.enums.ExceptionType;

public class BizException extends RuntimeException{

    private final Integer code;

    public BizException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
