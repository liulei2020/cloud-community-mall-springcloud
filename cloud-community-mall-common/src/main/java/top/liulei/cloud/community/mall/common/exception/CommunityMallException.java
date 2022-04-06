package top.liulei.cloud.community.mall.common.exception;

/**
 * 描述：     统一异常
 */
public class CommunityMallException extends RuntimeException {

    private final Integer code;
    private final String message;

    public CommunityMallException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommunityMallException(CommunityMallExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
