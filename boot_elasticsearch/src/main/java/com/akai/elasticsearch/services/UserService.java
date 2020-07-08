package com.akai.elasticsearch.services;

import com.akai.elasticsearch.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    long count();

    User save(User commodity);

    void delete(User commodity);

    Iterable<User> getAll();

    List<User> getByName(String name);

    Page<User> pageQuery(Integer pageNo, Integer pageSize, String kw);

}
