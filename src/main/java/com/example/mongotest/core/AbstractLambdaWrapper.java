package com.example.mongotest.core;

import com.example.mongotest.core.condition.AbstractWrapper;
import com.example.mongotest.core.toolkit.support.SFunction;

/**
 * @author alex
 * @date 2021-10-26 18:04
 */
public class AbstractLambdaWrapper<T, Children extends AbstractLambdaWrapper<T, Children>> extends AbstractWrapper<T, SFunction<T, ?>, Children> {
}
