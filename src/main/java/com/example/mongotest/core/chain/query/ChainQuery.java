package com.example.mongotest.core.chain.query;

import com.example.mongotest.core.chain.ChainWrapper;
import com.example.mongotest.core.metadata.IPage;

import java.util.List;

/**
 * @author alex
 * @date 2021-10-26 10:36
 */
public interface ChainQuery<T> extends ChainWrapper<T> {

    /*default T findById(){
        return null;
    }*/

    default boolean exists(){
        return Boolean.FALSE;
    }


    default long count(){
        return 0L;
    }

    default List<T> list() {
        /*return this.getBaseMapper().selectList(this.getWrapper());*/
        return null;
    }

    default T one() {
        /*return this.getBaseMapper().selectOne(this.getWrapper());*/
        return null;
    }

    default <E extends IPage<T>> E page(E page) {
        /*return this.getBaseMapper().selectPage(page, this.getWrapper());*/
        return null;
    }
}
