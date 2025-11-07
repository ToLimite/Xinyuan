package com.xinyuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Xinyuan {
    private Long id;
    private String title;
    private String pic;
    private String context;
    private String school;
    private String contact;
    private int state;
    private LocalDateTime time;

}
