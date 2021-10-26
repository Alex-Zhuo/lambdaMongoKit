package com.example.mongotest;

import com.example.mongotest.core.toolkit.MongoServices;
import com.example.mongotest.entity.GooglePoiQueryLog;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author alex
 * @date 2021-10-26 11:25
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IMongoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IMongoTest {

    @Test
    public void testQuery(){
        MongoServices.query(GooglePoiQueryLog.class).eq("","");
    }

    @Test
    public void testLambdaQuery(){
        MongoServices.lambdaQuery(GooglePoiQueryLog.class).eq(GooglePoiQueryLog::getGid,2).list();
    }
}
