package com.akai.elasticsearch.repositories;

import com.akai.elasticsearch.entities.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User,String> {
}
