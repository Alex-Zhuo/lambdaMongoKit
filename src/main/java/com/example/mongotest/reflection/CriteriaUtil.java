package com.example.mongotest.reflection;

import org.springframework.data.mongodb.core.query.Criteria;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author alex
 * @date 2021-10-27 17:16
 */
public class CriteriaUtil {

    public static Criteria invoke(String methodName, String columnName, Object methodParam, Class<?> methodParamType) {
        Criteria criteria = new Criteria();
        try {
            Class<Criteria> clazz = Criteria.class;
            Constructor<Criteria> constructor = clazz.getConstructor(String.class);
            Object obj = constructor.newInstance(columnName);
            Method method = clazz.getDeclaredMethod(methodName, methodParamType);
            criteria = (Criteria) method.invoke(obj, methodParam);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return criteria;
    }
}
