package cn.idwarf.lambdaMongoKit.core.chain.query;

import cn.idwarf.lambdaMongoKit.core.chain.AbstractChainWrapper;

/**
 * @author alex
 * @date 2021-10-26 10:42
 */
public class QueryChainWrapper<T> extends AbstractChainWrapper<T, String, QueryChainWrapper<T>> implements ChainQuery<T> {

    public QueryChainWrapper(String collectionName, Class<T> clazz) {
        super(collectionName, clazz);
    }


}
