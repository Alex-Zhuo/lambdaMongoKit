package cn.idwarf.lambdaMongoKit;

import cn.idwarf.lambdaMongoKit.core.toolkit.MongoServices;
import cn.idwarf.lambdaMongoKit.entity.GEO;
import cn.idwarf.lambdaMongoKit.entity.GooglePoiQueryLog;
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
@SpringBootTest(classes = LambdaMongoKitApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IMongoTest {

    @Test
    public void testQuery() {
        MongoServices.query(GooglePoiQueryLog.class).eq("", "");
    }

    @Test
    public void testLambdaQuery() {
        MongoServices.lambdaQuery(GooglePoiQueryLog.class).eq(GooglePoiQueryLog::getGid, 2).list();
    }

    @Test
    public void columnTest() {
        GooglePoiQueryLog queryLog = new GooglePoiQueryLog().setGeo(new GEO("1", "2"));
    }
}
