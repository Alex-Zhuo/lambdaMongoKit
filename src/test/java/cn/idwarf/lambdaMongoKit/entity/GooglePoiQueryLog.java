package cn.idwarf.lambdaMongoKit.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author alex
 * @date 2021-10-21 12:12
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@Document
public class GooglePoiQueryLog {

    private ObjectId id;

    private String gid;

    private String name;

    private String type;

    private String latlng;

    private GEO geo;
}
