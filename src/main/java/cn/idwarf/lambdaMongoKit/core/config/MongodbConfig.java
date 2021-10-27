package cn.idwarf.lambdaMongoKit.core.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * mongo配置
 *
 *  @author alex
 *  @date 2021/10/26 10:09
 */
@Configuration
@Slf4j
//@EnableConfigurationProperties(MongoClientOptionProperties.class)
public class MongodbConfig extends AbstractMongoClientConfiguration {

    @Autowired
    private MongoClientOptionProperties properties;

    @Autowired
    private MappingMongoConverter mappingMongoConverter;

    // remove _class
    @PostConstruct
    public void setUpMongoEscapeCharacterConversion() {
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }


    @Override
    protected String getDatabaseName() {
        return properties.getDatabase();
    }

    @Override
    public void configureClientSettings(MongoClientSettings.Builder builder) {
        log.info("[mongo] In the initialization....");
        //创建客户端和Factory
        String username = properties.getUsername();
        String password = properties.getPassword();
        String database = properties.getDatabase();


        MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());

        builder.credential(credential)
                .applicationName(properties.getClientName())
                .applyToClusterSettings(clusterBuilder ->
                        clusterBuilder.hosts(List.of(new ServerAddress(properties.getHost(), properties.getPort())))
                )
                .applyToConnectionPoolSettings(connPoolBuilder ->
                        connPoolBuilder
                                .maxConnectionIdleTime(properties.getMaxConnectionIdleTimeMs(), TimeUnit.MILLISECONDS)
                                .maxWaitTime(properties.getPoolMaxWaitTimeMs(), TimeUnit.MILLISECONDS)
                                .minSize(properties.getPoolMinSize())
                                .maxSize(properties.getPoolMaxSize())
                )
                .applyToSocketSettings(socketBuilder ->
                        socketBuilder
                                .connectTimeout(properties.getConnectionTimeoutMs(), TimeUnit.MILLISECONDS)
                                .readTimeout(properties.getReadTimeoutMs(), TimeUnit.MILLISECONDS)
                )
                .readPreference(ReadPreference.secondaryPreferred())
                .build();
    }
}
