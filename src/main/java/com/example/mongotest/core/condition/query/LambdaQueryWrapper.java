package com.example.mongotest.core.condition.query;

import com.example.mongotest.core.condition.AbstractWrapper;
import com.example.mongotest.core.service.Service;
import com.example.mongotest.core.toolkit.support.SFunction;

/**
 * @author alex
 * @date 2021-10-26 10:44
 */
public class LambdaQueryWrapper<T> extends AbstractWrapper<T, SFunction<T, ?>, LambdaQueryWrapper<T>> implements Query<T>, Service<T> {

    public LambdaQueryWrapper(Class<T> clazz) {
        super(clazz);
    }
}
