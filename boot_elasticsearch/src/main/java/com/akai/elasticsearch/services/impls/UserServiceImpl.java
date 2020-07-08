package com.akai.elasticsearch.services.impls;

import com.akai.elasticsearch.entities.User;
import com.akai.elasticsearch.repositories.UserRepository;
import com.akai.elasticsearch.services.UserService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MatchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public long count(){
        return userRepository.count();
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public void delete(User user){
        userRepository.delete(user);
    }

    @Override
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public List<User> getByName(String name){
        List<User> list=new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder=new MatchQueryBuilder("name",name);
        Iterable<User> iterable=userRepository.search(matchQueryBuilder);
        for(User u:iterable){
            list.add(u);
        }
        return list;
    }

    @Override
    public Page<User> pageQuery(Integer pageNo, Integer pageSize, String kw){
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("name", kw))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return userRepository.search(searchQuery);

    }
}
