package vn.edu.iuh.fit.dto;

import java.time.LocalDate;

public class PostDTO {

    private int postId;
    private String title;
    private String content;
    private LocalDate createdAt;
    private UserDTO user;
}
