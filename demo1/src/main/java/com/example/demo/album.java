package com.example.demo;

import io.swagger.models.auth.In;
import lombok.Builder;
import lombok.Data;

@Data
public class album {
    private Integer id;
    private Integer graph_id;
    private String title;
    private String p_style;
    private Long price;
    private String grapher_name;
}
