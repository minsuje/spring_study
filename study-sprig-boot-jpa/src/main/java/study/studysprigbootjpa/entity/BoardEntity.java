package study.studysprigbootjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 15)
    private String title;

    @Column(nullable = false, length = 30)
    private String content;

    @Column(nullable = false, length = 10)
    private String writer;

    @CreationTimestamp
    @Column(name = "Create_at")
    @Builder.Default
    private LocalDateTime registered = LocalDateTime.now();
}
