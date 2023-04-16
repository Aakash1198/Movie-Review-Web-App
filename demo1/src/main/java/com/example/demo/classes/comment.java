package com.example.demo.classes;

import lombok.Data;

@Data
public class comment {
    private Integer user_id;
    private Integer media_id;
    private Integer comment_type;
    private Integer comment_id;
    private Integer father_id;
    private String comment;

}
