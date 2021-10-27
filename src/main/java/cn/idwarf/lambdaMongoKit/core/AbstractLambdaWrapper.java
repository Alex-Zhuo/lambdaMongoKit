package cn.idwarf.lambdaMongoKit.core;

import cn.idwarf.lambdaMongoKit.core.executor.AbstractWrapper;
import cn.idwarf.lambdaMongoKit.core.toolkit.support.SFunction;

/**
 * @author alex
 * @date 2021-10-26 18:04
 */
public class AbstractLambdaWrapper<T, Children extends AbstractLambdaWrapper<T, Children>> extends AbstractWrapper<T, SFunction<T, ?>, Children> {
}
