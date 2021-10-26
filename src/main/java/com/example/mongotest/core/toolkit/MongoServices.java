package com.example.mongotest.core.toolkit;

import com.example.mongotest.core.condition.query.LambdaQueryWrapper;
import com.example.mongotest.core.condition.query.QueryWrapper;

/**
 * @author alex
 */
public final class MongoServices {
    private MongoServices() {
    }

    public static <T> QueryWrapper<T> query(Class<T> clazz) {
        return new QueryWrapper<>(clazz);
    }

    public static <T> LambdaQueryWrapper<T> lambdaQuery(Class<T> clazz) {
        return new LambdaQueryWrapper<>(clazz);
    }

    /*public static <T> QueryWrapper<T> query(String collectionName) {
        return new QueryWrapper<>(collectionName);
    }

    public static <T> LambdaQueryWrapper<T> lambdaQuery(String collectionName) {
        return new QueryWrapper<>(collectionName);
    }*/

    /*public static <T> UpdateChainWrapper<T> update(Class<T> clazz) {
        return new UpdateChainWrapper(clazz);
    }

    public static <T> LambdaUpdateChainWrapper<T> lambdaUpdate(Class<T> clazz) {
        return new LambdaUpdateChainWrapper(clazz);
    }*/
}