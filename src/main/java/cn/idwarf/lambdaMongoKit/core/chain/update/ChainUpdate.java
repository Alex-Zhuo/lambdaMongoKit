package cn.idwarf.lambdaMongoKit.core.chain.update;

import cn.idwarf.lambdaMongoKit.core.chain.ChainWrapper;

/**
 * @author alex
 * @date 2021-10-26 10:37
 */
public interface ChainUpdate<T> extends ChainWrapper<T> {

    default boolean update(T entity) {
        /*return SqlHelper.retBool(this.getBaseMapper().update(entity, this.getWrapper()));*/
        return Boolean.FALSE;
    }

    default boolean remove() {
        /*return SqlHelper.retBool(this.getBaseMapper().delete(this.getWrapper()));*/
        return Boolean.FALSE;
    }
}
