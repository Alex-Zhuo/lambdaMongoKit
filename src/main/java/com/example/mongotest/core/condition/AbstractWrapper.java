package com.example.mongotest.core.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * @author alex
 * @date 2021-10-26 10:38
 */
@Slf4j
public abstract class AbstractWrapper<T, R, Children extends AbstractWrapper<T, R, Children>> implements Compare<Children, R> {
    protected final Children typedThis = (Children) this;
    protected T entity;
    protected Class<T> entityClass;
    protected String collectionName;

    public AbstractWrapper() {
    }

    public AbstractWrapper(Class<T> entityClass) {
        this.entityClass = entityClass;
        String className = entityClass.getSimpleName();
        try {
            this.entity = entityClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            log.error("cannot create instance through reflection, class name:{}", className);
            e.printStackTrace();
        }
        String collectionName = null;
        Document document = entityClass.getAnnotation(Document.class);
        if (Objects.nonNull(document) && document.collection().length() > 0) {
            collectionName = document.collection();
        }
        this.collectionName = Objects.nonNull(collectionName) && collectionName.length() > 0 ? collectionName : className;
    }

    @Override
    public <V> Children allEq(boolean condition, Map<R, V> params, boolean null2IsNull) {
        /*this.getWrapper().allEq(condition, params, null2IsNull);*/
        return this.typedThis;
    }

    @Override
    public <V> Children allEq(boolean condition, BiPredicate<R, V> filter, Map<R, V> params, boolean null2IsNull) {
        /*this.getWrapper().allEq(condition, filter, params, null2IsNull);*/
        return this.typedThis;
    }

    @Override
    public Children eq(boolean condition, R column, Object val) {
        /*this.getWrapper().eq(condition, column, val);*/
        return this.typedThis;
    }

    @Override
    public Children ne(boolean condition, R column, Object val) {
        /*this.getWrapper().ne(condition, column, val);*/
        return this.typedThis;
    }

    @Override
    public Children gt(boolean condition, R column, Object val) {
        /*this.getWrapper().gt(condition, column, val);*/
        return this.typedThis;
    }

    @Override
    public Children ge(boolean condition, R column, Object val) {
        /*this.getWrapper().ge(condition, column, val);*/
        return this.typedThis;
    }

    @Override
    public Children lt(boolean condition, R column, Object val) {
        /*this.getWrapper().lt(condition, column, val);*/
        return this.typedThis;
    }

    @Override
    public Children le(boolean condition, R column, Object val) {
        /*this.getWrapper().le(condition, column, val);*/
        return this.typedThis;
    }

    @Override
    public Children between(boolean condition, R column, Object val1, Object val2) {
        /*this.getWrapper().between(condition, column, val1, val2);*/
        return this.typedThis;
    }

    @Override
    public Children notBetween(boolean condition, R column, Object val1, Object val2) {
        /*this.getWrapper().notBetween(condition, column, val1, val2);*/
        return this.typedThis;
    }

    @Override
    public Children like(boolean condition, R column, Object val) {
        /*this.getWrapper().like(condition, column, val);*/
        return this.typedThis;
    }

    @Override
    public Children notLike(boolean condition, R column, Object val) {
        /*this.getWrapper().notLike(condition, column, val);*/
        return this.typedThis;
    }

    @Override
    public Children likeLeft(boolean condition, R column, Object val) {
        /*this.getWrapper().likeLeft(condition, column, val);*/
        return this.typedThis;
    }

    @Override
    public Children likeRight(boolean condition, R column, Object val) {
        /*this.getWrapper().likeRight(condition, column, val);*/
        return this.typedThis;
    }
/*
    public Children isNull(boolean condition, R column) {
        this.getWrapper().isNull(condition, column);
        return this.typedThis;
    }

    public Children isNotNull(boolean condition, R column) {
        this.getWrapper().isNotNull(condition, column);
        return this.typedThis;
    }

    public Children in(boolean condition, R column, Collection<?> coll) {
        this.getWrapper().in(condition, column, coll);
        return this.typedThis;
    }

    public Children notIn(boolean condition, R column, Collection<?> coll) {
        this.getWrapper().notIn(condition, column, coll);
        return this.typedThis;
    }

    public Children inSql(boolean condition, R column, String inValue) {
        this.getWrapper().inSql(condition, column, inValue);
        return this.typedThis;
    }

    public Children notInSql(boolean condition, R column, String inValue) {
        this.getWrapper().notInSql(condition, column, inValue);
        return this.typedThis;
    }

    public Children groupBy(boolean condition, R... columns) {
        this.getWrapper().groupBy(condition, columns);
        return this.typedThis;
    }

    public Children orderBy(boolean condition, boolean isAsc, R... columns) {
        this.getWrapper().orderBy(condition, isAsc, columns);
        return this.typedThis;
    }

    public Children having(boolean condition, String sqlHaving, Object... params) {
        this.getWrapper().having(condition, sqlHaving, params);
        return this.typedThis;
    }

    public Children func(boolean condition, Consumer<Children> consumer) {
        if (condition) {
            consumer.accept(this.typedThis);
        }

        return this.typedThis;
    }

    public Children or(boolean condition) {
        this.getWrapper().or(condition);
        return this.typedThis;
    }

    public Children apply(boolean condition, String applySql, Object... value) {
        this.getWrapper().apply(condition, applySql, value);
        return this.typedThis;
    }

    public Children last(boolean condition, String lastSql) {
        this.getWrapper().last(condition, lastSql);
        return this.typedThis;
    }

    public Children comment(boolean condition, String comment) {
        this.getWrapper().comment(condition, comment);
        return this.typedThis;
    }

    public Children first(boolean condition, String firstSql) {
        this.getWrapper().first(condition, firstSql);
        return this.typedThis;
    }

    public Children exists(boolean condition, String existsSql) {
        this.getWrapper().exists(condition, existsSql);
        return this.typedThis;
    }

    public Children notExists(boolean condition, String existsSql) {
        this.getWrapper().notExists(condition, existsSql);
        return this.typedThis;
    }

    public Children and(boolean condition, Consumer<Param> consumer) {
        this.getWrapper().and(condition, consumer);
        return this.typedThis;
    }

    public Children or(boolean condition, Consumer<Param> consumer) {
        this.getWrapper().or(condition, consumer);
        return this.typedThis;
    }

    public Children nested(boolean condition, Consumer<Param> consumer) {
        this.getWrapper().nested(condition, consumer);
        return this.typedThis;
    }

    public Children not(boolean condition, Consumer<Param> consumer) {
        this.getWrapper().not(condition, consumer);
        return this.typedThis;
    }*/
}
