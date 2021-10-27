package cn.idwarf.lambdaMongoKit.core.enums;

import lombok.Data;

/**
 * @author alex
 * @date 2021-10-27 16:50
 */
public enum MethodKeyword {

    /**
     * method keyword
     */
    EQ("is"),
    NE("ne"),
    GT("gt"),
    GE("gte"),
    LT("lt"),
    LE("lte"),
    REGEX("regex"),
    IN("in"),
    NOT_IN("nin"),
    ;

    private final String methodName;

    public String getMethod() {
        return this.methodName;
    }

    private MethodKeyword(final String methodName) {
        this.methodName = methodName;
    }
}
