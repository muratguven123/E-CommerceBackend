package Response;

import Entities.User;
import lombok.Data;

@Data
public class UserResponse {
Long id;
int avatarId;
String userName;

public UserResponse(User entity) {
    this.id = entity.getId();
    this.avatarId = Math.toIntExact(entity.getId());
    this.userName = entity.getUsername();
}
}
