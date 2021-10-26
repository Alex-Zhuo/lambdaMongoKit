package com.example.mongotest.core.chain.query;

import com.example.mongotest.core.chain.AbstractChainWrapper;
import com.example.mongotest.core.condition.query.LambdaQueryWrapper;
import com.example.mongotest.core.service.Service;
import com.example.mongotest.core.toolkit.support.SFunction;

/**
 * @author alex
 * @date 2021-10-26 10:44
 */
public class LambdaQueryChainWrapper<T> extends AbstractChainWrapper<T, SFunction<T, ?>, LambdaQueryChainWrapper<T>, LambdaQueryWrapper<T>> implements ChainQuery<T>, Service<T> {

    public LambdaQueryChainWrapper(Class<T> clazz) {
        super(clazz);
    }
}
