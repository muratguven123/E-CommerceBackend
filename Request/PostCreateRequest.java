package Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class PostCreateRequest {
    Long id;
    @Getter
    @Setter
    String text;
    @Setter
    @Getter
    String title;
    int userid;

    public int getUserId() {
        return userid;
    }
    public void setUserId(int userid) {
        this.userid = userid;
    }

}
