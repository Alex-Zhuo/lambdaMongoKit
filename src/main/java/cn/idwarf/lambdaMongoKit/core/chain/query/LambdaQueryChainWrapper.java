package cn.idwarf.lambdaMongoKit.core.chain.query;

import cn.idwarf.lambdaMongoKit.core.chain.AbstractChainWrapper;
import cn.idwarf.lambdaMongoKit.core.service.Service;
import cn.idwarf.lambdaMongoKit.core.toolkit.ColumnUtils;
import cn.idwarf.lambdaMongoKit.core.toolkit.support.SFunction;

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
