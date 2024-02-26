package mybatis.minsuspringbootmybatis.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Board {
    private int id;
    private String title;
    private String content;
    private String writer;
    private String registered;
}
