package study.studysprigbootjpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private int id;
    private String name;
    private String nickname;
    private int no;

    public String getUser() {
        return id + name + nickname;
    }
}
