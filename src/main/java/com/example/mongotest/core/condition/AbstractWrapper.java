package com.example.mongotest.core.condition;

import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author alex
 * @date 2021-10-26 18:00
 */
public class AbstractWrapper<T, R, Children extends AbstractWrapper<T, R, Children>> implements Compare<Children, R> {

    public static final String COMMA = ",";

    protected Query query;
    private T entity;
    private Class<T> entityClass;
    protected final Children typedThis = (Children) this;

    public AbstractWrapper() {
    }

    public Query getQuery() {
        return this.query;
    }

    public T getEntity() {
        return this.entity;
    }

    public Children setEntity(T entity) {
        this.entity = entity;
        return this.typedThis;
    }

    protected Class<T> getEntityClass() {
        if (this.entityClass == null && this.entity != null) {
            this.entityClass = (Class<T>) this.entity.getClass();
        }

        return this.entityClass;
    }

    public Children setEntityClass(Class<T> entityClass) {
        if (entityClass != null) {
            this.entityClass = entityClass;
        }

        return this.typedThis;
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

    /*@Override
    public Children between(boolean condition, R column, Object val1, Object val2) {
        return null;
    }

    @Override
    public Children notBetween(boolean condition, R column, Object val1, Object val2) {
        return null;
    }*/

    @Override
    public Children like(boolean condition, R column, String val) {
        return null;
    }

    @Override
    public Children notLike(boolean condition, R column, String val) {
        return null;
    }

    @Override
    public Children likeLeft(boolean condition, R column, String val) {
        return null;
    }

    @Override
    public Children likeRight(boolean condition, R column, String val) {
        return null;
    }

    @Override
    public Children regex(boolean condition, R column, String regex) {
        return null;
    }

    @Override
    public Children in(boolean condition, R column, Collection<?> values) {
        return null;
    }

    @Override
    public Children notIn(boolean condition, R column, Collection<?> values) {
        return null;
    }

    /**
     * 获取 columnNames
     */
    @SafeVarargs
    protected final String columnsToString(R... columns) {
        return Arrays.stream(columns).map(this::columnToString).collect(Collectors.joining(COMMA));
    }

    /**
     * 多字段转换为逗号 "," 分割字符串
     *
     * @param columns 多字段
     */
    protected String columnsToString(List<R> columns) {
        return columns.stream().map(this::columnToString).collect(Collectors.joining(COMMA));
    }

    /**
     * 获取 columnName
     */
    protected String columnToString(R column) {
        return (String) column;
    }
}
