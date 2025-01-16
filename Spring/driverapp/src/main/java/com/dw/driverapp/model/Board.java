package com.dw.driverapp.model;

import com.dw.driverapp.dto.BoardDTO;
import com.dw.driverapp.dto.SubjectDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="게시판")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false, columnDefinition = "TEXT") // 65535 byte
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_name", nullable = false)
    private User author;
    @Column(name="created_date", nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();
    @Column(name="modified_date", nullable = false)
    private LocalDateTime modifiedDate = LocalDateTime.now();
    @OneToMany(mappedBy = "board")
    private List<Comment>commentList = new ArrayList<>();

    public BoardDTO toDTO() {
       BoardDTO boardDTO = new BoardDTO();
       boardDTO.setId(this.id);
       boardDTO.setTitle(this.title);
       List<Long> comments = new ArrayList<>();
       for (Comment data : commentList) {
            comments.add(data.getId());
       }
       boardDTO.setCommentList(comments);
        List<User> comments1 = new ArrayList<>();
        for (Comment data : commentList) {
            comments1.add(data.getUser());
        }
        boardDTO.setCommentList1(comments1);
        List<String> comments2 = new ArrayList<>();
        for (Comment data : commentList) {
            comments2.add(data.getComment());
        }
        boardDTO.setCommentList2(comments2);


    }
}
}
