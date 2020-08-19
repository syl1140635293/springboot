package com.exam.model.type;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Type {
    private Long id;

    private String uuid;

    private String name;

    private String creater;

    private String createTime;

    private String deleteTime;

    private Integer isDelete;
}