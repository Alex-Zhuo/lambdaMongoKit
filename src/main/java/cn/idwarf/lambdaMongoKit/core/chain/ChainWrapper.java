package cn.idwarf.lambdaMongoKit.core.chain;

import cn.idwarf.lambdaMongoKit.core.executor.AbstractWrapper;

/**
 * @author alex
 * @date 2021-10-26 10:34
 */
public interface ChainWrapper<T, Wrapper extends AbstractWrapper<T, Wrapper>> {
    AbstractWrapper<T, Wrapper> getWrapper();
}
