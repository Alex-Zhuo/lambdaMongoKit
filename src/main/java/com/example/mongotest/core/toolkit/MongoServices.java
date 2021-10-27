package com.example.mongotest.core.toolkit;

import com.example.mongotest.core.chain.query.LambdaQueryChainWrapper;
import com.example.mongotest.core.chain.query.QueryChainWrapper;

/**
 * @author alex
 */
public final class MongoServices {
    private MongoServices() {
    }

    public static <T> QueryChainWrapper<T> query(String collectionName, Class<T> clazz) {
        return new QueryChainWrapper<>(collectionName, clazz);
    }

    public static <T> QueryChainWrapper<T> query(Class<T> clazz) {
        return query(null, clazz);
    }

    public static <T> LambdaQueryChainWrapper<T> lambdaQuery(String collectionName, Class<T> clazz) {
        return new LambdaQueryChainWrapper<>(collectionName, clazz);
    }

    public static <T> LambdaQueryChainWrapper<T> lambdaQuery(Class<T> clazz) {
        return lambdaQuery(null, clazz);
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