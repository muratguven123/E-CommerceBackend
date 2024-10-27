package Request;

import Entities.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CommentCreateRequest {
    Long id;
    @Getter
    @Setter
    String text;
    @Setter
    @Getter
    String title;
    int userid;
    int postid;

}
