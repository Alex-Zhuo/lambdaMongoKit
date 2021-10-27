package cn.idwarf.lambdaMongoKit.core.condition;

import cn.idwarf.lambdaMongoKit.core.toolkit.ColumnUtils;
import cn.idwarf.lambdaMongoKit.core.toolkit.support.SFunction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author alex
 * @date 2021-10-25 17:27
 */
@Slf4j
public class MongoBaseQuery<T> {
    private T entity;
    private Class<T> entityClass;
    private String collectionName;
    private Query query;

    @Autowired
    private MongoTemplate mongoTemplate;

    public MongoBaseQuery<T> query(Class<T> entityClass) {
        initEntity(entityClass);
        this.query = new Query();
        return this;
    }

    private void initEntity(Class<T> entityClass) {
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

    /**
     * 支持的操作：
     * in() 包含，如果key为_id会自动将文本id转为mongodb所需的ObjectId
     * eq() 等于
     * ne() 不等于
     * gt() 大于
     * lt() 小于
     * gte() 大于等于
     * lte() 小于等于
     * like() 模糊查找，like除了支持含有，还支持以什么开头或以什么结尾的查找。
     */
    private MongoBaseQuery<T> in(SFunction<T, ?> column, Collection<?> values) {
        return this.in(ColumnUtils.getName(column), values);
    }

    private MongoBaseQuery<T> in(SFunction<T, ?> column, Object... obj) {
        return this.in(ColumnUtils.getName(column), obj);
    }

    private MongoBaseQuery<T> eq(SFunction<T, ?> column, Object obj) {
        return this.eq(ColumnUtils.getName(column), obj);
    }

    private MongoBaseQuery<T> ne(SFunction<T, ?> column, Object obj) {
        return this.ne(ColumnUtils.getName(column), obj);
    }


    private MongoBaseQuery<T> notIn(SFunction<T, ?> column, Object... obj) {
        return this.notIn(ColumnUtils.getName(column), obj);
    }

    private MongoBaseQuery<T> notIn(SFunction<T, ?> column, Collection<?> values) {
        return this.notIn(ColumnUtils.getName(column), values);
    }

    private MongoBaseQuery<T> mod(SFunction<T, ?> column, Number value, Number remainder) {
        return this.mod(ColumnUtils.getName(column), value, remainder);
    }

    private MongoBaseQuery<T> regex(SFunction<T, ?> column, String regex) {
        return this.regex(ColumnUtils.getName(column), regex);
    }

    private MongoBaseQuery<T> orderByAsc(SFunction<T, ?> column) {
        return this.orderByAsc(ColumnUtils.getName(column));
    }

    private MongoBaseQuery<T> orderByDesc(SFunction<T, ?> column) {
        return this.orderByDesc(ColumnUtils.getName(column));
    }

    private MongoBaseQuery<T> in(String column, Collection<?> values) {
        this.query.addCriteria(new Criteria(column).in(values));
        return this;
    }

    private MongoBaseQuery<T> in(String column, Object... obj) {
        this.query.addCriteria(new Criteria(column).in(obj));
        return this;
    }

    private MongoBaseQuery<T> eq(String column, Object obj) {
        this.query.addCriteria(new Criteria(column).is(obj));
        return this;
    }

    private MongoBaseQuery<T> ne(String column, Object obj) {
        this.query.addCriteria(new Criteria(column).ne(obj));
        return this;
    }

    private MongoBaseQuery<T> orderByAsc(String column) {
        this.query.with(Sort.by(Sort.Direction.ASC, column));
        return this;
    }

    private MongoBaseQuery<T> orderByDesc(String column) {
        this.query.with(Sort.by(Sort.Direction.DESC, column));
        return this;
    }

    private MongoBaseQuery<T> gt(String column, Object obj) {
        this.query.addCriteria(new Criteria(column).gt(obj));
        return this;
    }

    private MongoBaseQuery<T> gte(String column, Object obj) {
        this.query.addCriteria(new Criteria(column).gte(obj));
        return this;
    }

    private MongoBaseQuery<T> lt(String column, Object obj) {
        this.query.addCriteria(new Criteria(column).lt(obj));
        return this;
    }

    private MongoBaseQuery<T> lte(String column, Object obj) {
        this.query.addCriteria(new Criteria(column).lte(obj));
        return this;
    }

    private MongoBaseQuery<T> notIn(String column, Object... obj) {
        this.query.addCriteria(new Criteria(column).nin(obj));
        return this;
    }

    private MongoBaseQuery<T> notIn(String column, Collection<?> values) {
        this.query.addCriteria(new Criteria(column).nin(values));
        return this;
    }

    private MongoBaseQuery<T> mod(String column, Number value, Number remainder) {
        this.query.addCriteria(new Criteria(column).mod(value, remainder));
        return this;
    }

    private MongoBaseQuery<T> or(String column, Collection<?> values) {
        Criteria criteria = new Criteria(column);
        if (Objects.nonNull(values)) {
            List<Criteria> orOperators = values.stream().map(value -> new Criteria(column).is(value)).collect(Collectors.toList());
            criteria.orOperator(orOperators);
        }
        this.query.addCriteria(criteria);
        return this;
    }

    private MongoBaseQuery<T> or(String column, Object... obj) {
        return this.or(column, Arrays.asList(obj));
    }

    private MongoBaseQuery<T> regex(String column, String regex) {
        /*//完全匹配
        Pattern pattern = Pattern.compile("^王$", Pattern.CASE_INSENSITIVE);
        //右匹配
        Pattern pattern = Pattern.compile("^.*王$", Pattern.CASE_INSENSITIVE);
        //左匹配
        Pattern pattern = Pattern.compile("^王.*$", Pattern.CASE_INSENSITIVE);
        //模糊匹配
        Pattern pattern = Pattern.compile("^.*王.*$", Pattern.CASE_INSENSITIVE);*/
        this.query.addCriteria(new Criteria(column).regex(regex));
        return this;
    }

    private T findOne() {
        return mongoTemplate.findOne(this.query, entityClass, this.collectionName);
    }

    private List<T> find(Long skip, Integer limit) {
        this.query.skip(skip).limit(limit);
        return mongoTemplate.find(this.query, entityClass, this.collectionName);
    }
}
