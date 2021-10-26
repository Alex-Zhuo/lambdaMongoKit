package com.example.mongotest.core.condition;

import java.util.Map;
import java.util.function.BiPredicate;

/**
 * @author alex
 * @date 2021-10-26 18:00
 */
public class AbstractWrapper<T, R, Children extends AbstractWrapper<T, R, Children>> implements Compare<Children, R>{
    @Override
    public <V> Children allEq(boolean condition, Map<R, V> params, boolean null2IsNull) {
        return null;
    }

    @Override
    public <V> Children allEq(boolean condition, BiPredicate<R, V> filter, Map<R, V> params, boolean null2IsNull) {
        return null;
    }

    @Override
    public Children eq(boolean condition, R column, Object val) {
        return null;
    }

    @Override
    public Children ne(boolean condition, R column, Object val) {
        return null;
    }

    @Override
    public Children gt(boolean condition, R column, Object val) {
        return null;
    }

    @Override
    public Children ge(boolean condition, R column, Object val) {
        return null;
    }

    @Override
    public Children lt(boolean condition, R column, Object val) {
        return null;
    }

    @Override
    public Children le(boolean condition, R column, Object val) {
        return null;
    }

    @Override
    public Children between(boolean condition, R column, Object val1, Object val2) {
        return null;
    }

    @Override
    public Children notBetween(boolean condition, R column, Object val1, Object val2) {
        return null;
    }

    @Override
    public Children like(boolean condition, R column, Object val) {
        return null;
    }

    @Override
    public Children notLike(boolean condition, R column, Object val) {
        return null;
    }

    @Override
    public Children likeLeft(boolean condition, R column, Object val) {
        return null;
    }

    @Override
    public Children likeRight(boolean condition, R column, Object val) {
        return null;
    }
}
