package Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LikeCreateRequest {
    Long id;
    @Getter
    @Setter
    String text;
    @Setter
    @Getter
    String title;
    int userid;
}
