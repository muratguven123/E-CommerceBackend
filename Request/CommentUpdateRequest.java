package Request;

import lombok.Data;

@Data
public class CommentUpdateRequest {
    String title;
    String text;
}
