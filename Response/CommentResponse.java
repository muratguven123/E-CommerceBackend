package Response;

import lombok.Data;

@Data
public class CommentResponse {
int id;
int userId;
String userName;
String text;

public CommentResponse(int id, int userId, String userName, String text) {
    this.id = id;
    this.userId = userId;
    this.userName = userName;
    this.text = text;
}

}
