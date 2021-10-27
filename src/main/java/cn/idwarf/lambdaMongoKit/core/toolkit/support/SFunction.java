package cn.idwarf.lambdaMongoKit.core.toolkit.support;

import java.io.Serializable;
import java.util.function.Function;

/**
 * 使Function获取序列化能力
 *
 * @author alex
 */
@FunctionalInterface
public interface SFunction<T, R> extends Function<T, R>, Serializable {
}