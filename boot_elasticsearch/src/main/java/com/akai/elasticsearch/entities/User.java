package com.akai.elasticsearch.entities;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;


@Data
@Document(indexName = "user")
public class User implements Serializable {
    private Long id;

    private String userName;

    private String name;

    private String sex;
}
