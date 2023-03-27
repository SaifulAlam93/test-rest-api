package com.saiful.restApi.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class Post extends BaseModel {

    private String title;
    private String body;
}
