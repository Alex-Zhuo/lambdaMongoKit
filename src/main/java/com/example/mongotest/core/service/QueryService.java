package com.example.mongotest.core.service;

import com.example.mongotest.core.metadata.IPage;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author alex
 */
public interface QueryService<T> extends Service<T> {

    int insert(T entity);

    int deleteById(Serializable id);

    int deleteByMap(Map<String, Object> columnMap);

    int delete(Service<T> service);

    int deleteBatchIds(Collection<? extends Serializable> idList);

    int updateById(T entity);

    int update(T entity, Service<T> updateService);

    T selectById(Serializable id);

    List<T> selectBatchIds(Collection<? extends Serializable> idList);

    List<T> selectByMap(Map<String, Object> columnMap);

    T selectOne(Service<T> queryService);

    Integer selectCount(Service<T> queryService);

    List<T> selectList(Service<T> queryService);

    List<Map<String, Object>> selectMaps(Service<T> queryService);

    List<Object> selectObjs(Service<T> queryService);

    <E extends IPage<T>> E selectPage(E page, Service<T> queryService);

    <E extends IPage<Map<String, Object>>> E selectMapsPage(E page, Service<T> queryService);
}