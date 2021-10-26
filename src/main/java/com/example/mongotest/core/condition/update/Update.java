package com.example.mongotest.core.condition.update;

import com.example.mongotest.core.condition.Wrapper;

import java.io.Serializable;

/**
 * @author alex
 * @date 2021-10-26 10:37
 */
public interface Update<T> extends Wrapper<T> {

    default boolean update(T entity) {
        /*return SqlHelper.retBool(this.getBaseMapper().update(entity, this.getWrapper()));*/
        return Boolean.FALSE;
    }

    default boolean remove() {
        /*return SqlHelper.retBool(this.getBaseMapper().delete(this.getWrapper()));*/
        return Boolean.FALSE;
    }
}
