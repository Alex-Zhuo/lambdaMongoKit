package cn.idwarf.lambdaMongoKit.core.executor.query;

import cn.idwarf.lambdaMongoKit.core.executor.AbstractWrapper;

/**
 * @author alex
 * @date 2021-10-26 17:57
 */
public class LambdaQueryWrapper<T> extends AbstractWrapper<T, LambdaQueryWrapper<T>> {

    public LambdaQueryWrapper(){
        System.out.println("init");
    }
}
