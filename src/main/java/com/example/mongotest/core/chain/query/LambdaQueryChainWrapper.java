package com.example.mongotest.core.chain.query;

import com.example.mongotest.core.chain.AbstractChainWrapper;
import com.example.mongotest.core.service.Service;
import com.example.mongotest.core.toolkit.ColumnUtils;
import com.example.mongotest.core.toolkit.support.SFunction;

/**
 * @author alex
 * @date 2021-10-26 10:44
 */
public class LambdaQueryChainWrapper<T> extends AbstractChainWrapper<T, SFunction<T, ?>, LambdaQueryChainWrapper<T>> implements ChainQuery<T>, Service<T> {

    public LambdaQueryChainWrapper(String collectionName, Class<T> clazz) {
        super(collectionName, clazz);
    }

    @Override
    protected String columnToString(SFunction<T, ?> column) {
        return ColumnUtils.getName(column);
    }

}
