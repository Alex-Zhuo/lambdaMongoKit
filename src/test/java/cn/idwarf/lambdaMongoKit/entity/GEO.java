package cn.idwarf.lambdaMongoKit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author alex
 * @date 2021-10-26 17:20
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@Document
@AllArgsConstructor
public class GEO {

    private String latitude;
    private String lang;
}
