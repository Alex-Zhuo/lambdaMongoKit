package com.example.mongotest.core.condition.query;

import com.example.mongotest.core.condition.AbstractWrapper;

/**
 * @author alex
 * @date 2021-10-26 10:42
 */
public class QueryWrapper<T> extends AbstractWrapper<T, String, QueryWrapper<T>> implements Query<T> {

    public QueryWrapper(Class<T> clazz){
        super(clazz);
    }
}
