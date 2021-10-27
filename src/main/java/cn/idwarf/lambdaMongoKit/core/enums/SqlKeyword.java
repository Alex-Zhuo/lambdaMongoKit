//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.idwarf.lambdaMongoKit.core.enums;


/**
 * @author klook
 */

public enum SqlKeyword {
    /**
     *private T entity;
     *     protected MergeSegments expression;
     *     private Class<T> entityClass;
     */
    AND("AND"),
    OR("OR"),
    NOT("NOT"),
    IN("IN"),
    NOT_IN("NOT IN"),
    LIKE("LIKE"),
    NOT_LIKE("NOT LIKE"),
    EQ("="),
    NE("<>"),
    GT(">"),
    GE(">="),
    LT("<"),
    LE("<="),
    IS_NULL("IS NULL"),
    IS_NOT_NULL("IS NOT NULL"),
    GROUP_BY("GROUP BY"),
    HAVING("HAVING"),
    ORDER_BY("ORDER BY"),
    EXISTS("EXISTS"),
    NOT_EXISTS("NOT EXISTS"),
    BETWEEN("BETWEEN"),
    NOT_BETWEEN("NOT BETWEEN"),
    ASC("ASC"),
    DESC("DESC");

    private final String keyword;

    public String getSqlSegment() {
        return this.keyword;
    }

    private SqlKeyword(final String keyword) {
        this.keyword = keyword;
    }
}
