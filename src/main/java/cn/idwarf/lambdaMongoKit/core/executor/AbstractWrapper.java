package cn.idwarf.lambdaMongoKit.core.executor;

import cn.idwarf.lambdaMongoKit.core.metadata.IPage;
import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author alex
 * @date 2021-10-26 18:00
 */
@Component
public class AbstractWrapper<T, Children extends AbstractWrapper<T, Children>> {

    protected final Children typedThis = (Children) this;
    private T entity;
    private Class<T> entityClass;
    protected String collectionName;
    protected Query query;
    public MongoTemplate mongoTemplate;
    @Autowired
    private MongoClient mongoClient;

    public AbstractWrapper() {
    }

    public T getEntity() {
        return entity;
    }

    public Children setEntity(T entity) {
        this.entity = entity;
        return typedThis;
    }

    public Query getQuery() {
        return query;
    }

    public Children setQuery(Query query) {
        this.query = query;
        return typedThis;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public Children setCollectionName(String collectionName) {
        this.collectionName = collectionName;
        return typedThis;
    }

    public Class<T> getEntityClass() {
        if (entityClass == null && entity != null) {
            entityClass = (Class<T>) entity.getClass();
        }
        return entityClass;
    }

    public Children setEntityClass(Class<T> entityClass) {
        if (entityClass != null) {
            this.entityClass = entityClass;
        }
        return typedThis;
    }

    public MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase(collectionName).getCollection(collectionName);
    }

    public boolean exists() {
        Block<Document> block = new Block<Document>() {

            @Override
            public void apply(Document document) {
                /*document = iding(document);
                document = jointing(document, join);
                list.add(toJSON(document));*/
            }
        };
        return this.mongoTemplate.exists(query, collectionName);
    }


    public long count() {
        return 0L;
    }

    public List<T> list() {
        /*return this.getBaseMapper().selectList(this.getWrapper());*/
        return this.mongoTemplate.findAllAndRemove(query, entityClass, collectionName);
    }

    public T one() {
        /*return this.getBaseMapper().selectOne(this.getWrapper());*/
        return null;
    }

    public <E extends IPage<T>> E page(E page) {
        /*return this.getBaseMapper().selectPage(page, this.getWrapper());*/
        return null;
    }

    public void update() {

    }
}
