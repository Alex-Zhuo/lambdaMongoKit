package com.example.mongotest.core.constant;

/**
 * @author alex
 * @date 2021-10-27 18:03
 */
public interface RegexConstant {
    public static final String ALL_MATCH = "^%s$";
    public static final String LEFT_MATCH = "^.*%s$";
    public static final String RIGHT_MATCH = "^%s.*$";
    public static final String FUZZY_MATCH = "^.*%s.*$";
    public static final String NOT_MATCH = "^((?!%s).)*$";
}
