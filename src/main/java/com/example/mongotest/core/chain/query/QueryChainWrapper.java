package com.example.mongotest.core.chain.query;

import com.example.mongotest.core.chain.AbstractChainWrapper;
import com.example.mongotest.core.condition.query.QueryWrapper;

/**
 * @author alex
 * @date 2021-10-26 10:42
 */
public class QueryChainWrapper<T> extends AbstractChainWrapper<T, String, QueryChainWrapper<T>, QueryWrapper<T>> implements ChainQuery<T> {

    public QueryChainWrapper(Class<T> clazz){
        super(clazz);
    }
}
