package cn.idwarf.lambdaMongoKit.core.chain;

import cn.idwarf.lambdaMongoKit.core.constant.RegexConstant;
import cn.idwarf.lambdaMongoKit.core.condition.Compare;
import cn.idwarf.lambdaMongoKit.core.enums.MethodKeyword;
import cn.idwarf.lambdaMongoKit.reflection.CriteriaUtil;
import cn.idwarf.lambdaMongoKit.util.PatternUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @param <T>        entity
 * @param <R>        column type, java.lang.String/Reference Type
 * @param <Children> impl
 * @author alex
 * @date 2021-10-26 10:38
 */
@Slf4j
public abstract class AbstractChainWrapper<T, R, Children extends AbstractChainWrapper<T, R, Children>> implements Compare<Children, R> {

    protected final Children typedThis = (Children) this;
    protected T entity;
    protected Class<T> entityClass;
    protected String collectionName;

    protected Query query;

    public AbstractChainWrapper() {
    }

    public AbstractChainWrapper(String collectionName, Class<T> entityClass) {
        this.entityClass = entityClass;
        String className = entityClass.getSimpleName();
        try {
            this.entity = entityClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            log.error("cannot create instance through reflection, class name:{}", className);
            e.printStackTrace();
        }
        Document document = entityClass.getAnnotation(Document.class);
        if (StringUtils.isEmpty(collectionName) && Objects.nonNull(document) && document.collection().length() > 0) {
            collectionName = document.collection();
        }
        this.collectionName = StringUtils.isNotEmpty(collectionName) ? collectionName : className;
        this.query = new Query();
    }

    @Override
    public Children eq(boolean condition, R column, Object val) {
        return this.doIt(condition, MethodKeyword.EQ, column, val, val.getClass());
    }

    @Override
    public Children ne(boolean condition, R column, Object val) {
        return this.doIt(condition, MethodKeyword.NE, column, val, val.getClass());
    }

    @Override
    public Children gt(boolean condition, R column, Object val) {
        return this.doIt(condition, MethodKeyword.GT, column, val, val.getClass());
    }

    @Override
    public Children ge(boolean condition, R column, Object val) {
        return this.doIt(condition, MethodKeyword.GE, column, val, val.getClass());
    }

    @Override
    public Children lt(boolean condition, R column, Object val) {
        return this.doIt(condition, MethodKeyword.LT, column, val, val.getClass());
    }

    @Override
    public Children le(boolean condition, R column, Object val) {
        return this.doIt(condition, MethodKeyword.LE, column, val, val.getClass());
    }

    /*@Override
    public Children between(boolean condition, R column, Object val1, Object val2) {
        this.le(condition,column,);
        
    }

    @Override
    public Children notBetween(boolean condition, R column, Object val1, Object val2) {
        this.getWrapper().notBetween(condition, column, val1, val2);
        
    }*/

    @Override
    public Children like(boolean condition, R column, String val) {
        return this.doIt(condition, MethodKeyword.REGEX, column, PatternUtil.getPattern(val, RegexConstant.FUZZY_MATCH), Pattern.class);
    }

    @Override
    public Children notLike(boolean condition, R column, String val) {
        return this.doIt(condition, MethodKeyword.REGEX, column, PatternUtil.getPattern(val, RegexConstant.NOT_MATCH), Pattern.class);
    }

    @Override
    public Children likeLeft(boolean condition, R column, String val) {
        return this.doIt(condition, MethodKeyword.REGEX, column, PatternUtil.getPattern(val, RegexConstant.LEFT_MATCH), Pattern.class);
    }

    @Override
    public Children likeRight(boolean condition, R column, String val) {
        return this.doIt(condition, MethodKeyword.REGEX, column, PatternUtil.getPattern(val, RegexConstant.RIGHT_MATCH), Pattern.class);
    }

    @Override
    public Children regex(boolean condition, R column, String regex) {
        return this.doIt(condition, MethodKeyword.REGEX, column, PatternUtil.getPattern(regex), Pattern.class);
    }

    @Override
    public Children in(boolean condition, R column, Collection<?> values) {
        return this.doIt(condition, MethodKeyword.IN, column, values, values.getClass());
    }

    @Override
    public Children notIn(boolean condition, R column, Collection<?> values) {
        return this.doIt(condition, MethodKeyword.NOT_IN, column, values, values.getClass());
    }

    protected String columnToString(R column) {
        return (String) column;
    }

    protected Children doIt(boolean condition, MethodKeyword methodKeyword, R column, Object methodParam, Class<?> methodParamType) {
        if (condition) {
            Criteria criteria = CriteriaUtil.invoke(methodKeyword.getMethod(), this.columnToString(column), methodParam, methodParamType);
            this.query.addCriteria(criteria);
        }
        return this.typedThis;
    }
/*
    public Children isNull(boolean condition, R column) {
        this.getWrapper().isNull(condition, column);
        
    }

    public Children isNotNull(boolean condition, R column) {
        this.getWrapper().isNotNull(condition, column);
        
    }

    public Children in(boolean condition, R column, Collection<?> coll) {
        this.getWrapper().in(condition, column, coll);
        
    }

    public Children notIn(boolean condition, R column, Collection<?> coll) {
        this.getWrapper().notIn(condition, column, coll);
        
    }

    public Children inSql(boolean condition, R column, String inValue) {
        this.getWrapper().inSql(condition, column, inValue);
        
    }

    public Children notInSql(boolean condition, R column, String inValue) {
        this.getWrapper().notInSql(condition, column, inValue);
        
    }

    public Children groupBy(boolean condition, R... columns) {
        this.getWrapper().groupBy(condition, columns);
        
    }

    public Children orderBy(boolean condition, boolean isAsc, R... columns) {
        this.getWrapper().orderBy(condition, isAsc, columns);
        
    }

    public Children having(boolean condition, String sqlHaving, Object... params) {
        this.getWrapper().having(condition, sqlHaving, params);
        
    }

    public Children func(boolean condition, Consumer<Children> consumer) {
        if (condition) {
            consumer.accept(this.typedThis);
        }

        
    }

    public Children or(boolean condition) {
        this.getWrapper().or(condition);
        
    }

    public Children apply(boolean condition, String applySql, Object... value) {
        this.getWrapper().apply(condition, applySql, value);
        
    }

    public Children last(boolean condition, String lastSql) {
        this.getWrapper().last(condition, lastSql);
        
    }

    public Children comment(boolean condition, String comment) {
        this.getWrapper().comment(condition, comment);
        
    }

    public Children first(boolean condition, String firstSql) {
        this.getWrapper().first(condition, firstSql);
        
    }

    public Children exists(boolean condition, String existsSql) {
        this.getWrapper().exists(condition, existsSql);
        
    }

    public Children notExists(boolean condition, String existsSql) {
        this.getWrapper().notExists(condition, existsSql);
        
    }

    public Children and(boolean condition, Consumer<Param> consumer) {
        this.getWrapper().and(condition, consumer);
        
    }

    public Children or(boolean condition, Consumer<Param> consumer) {
        this.getWrapper().or(condition, consumer);
        
    }

    public Children nested(boolean condition, Consumer<Param> consumer) {
        this.getWrapper().nested(condition, consumer);
        
    }

    public Children not(boolean condition, Consumer<Param> consumer) {
        this.getWrapper().not(condition, consumer);
        
    }*/
}
