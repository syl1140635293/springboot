package com.exam.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;

    private String uuid;

    private String openid;

    private String name;

    private String nickname;

    private Integer sex;

    private Integer phone;

    private String creater;

    private String createTime;

    private String updateTime;

    private String deleteTime;

    private Integer isDelete;
}