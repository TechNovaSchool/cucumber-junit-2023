package api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class Record {
    String id;
    String createdTime;
    Myfields fields;
}
