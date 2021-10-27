package cn.idwarf.lambdaMongoKit.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * mongo配置类
 *
 * @author alex
 * @date 2021/10/26 10:09
 */
@Data
@Validated
@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoClientOptionProperties {
    /**
     * 基础连接参数
     */
    @NotEmpty
    private String database;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private String host = "localhost";
    private int port = 27017;
    /**
     * 客户端连接池参数
     */
    private String clientName;

    /**
     * 连接池获取链接等待时间
     */
    @Min(value = 1)
    private int poolMaxWaitTimeMs;

    /**
     * 最大闲置时间 默认6s
     */
    private int maxConnectionIdleTimeMs = 6000;
    /**
     * 连接池最小多少个
     */
    @Min(value = 1)
    private int poolMinSize;
    /**
     * 连接池最大多少个
     */
    @Min(value = 1)
    private int poolMaxSize;

    /**
     * socket连接超时时间
     */
    @Min(value = 1)
    private int connectionTimeoutMs;
    /**
     * socket读取超时时间
     */
    @Min(value = 1)
    private int readTimeoutMs;

}
