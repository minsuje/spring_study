package study.studysprigbootjpa.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime registered;
}
