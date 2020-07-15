package com.example.demo.dao;

import com.example.demo.entity.MongoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;



    public void savMongo(MongoBean mongoBean) {
        mongoTemplate.save(mongoBean);
    }

    public List<MongoBean> findList() {
        return mongoTemplate.findAll(MongoBean.class);
    }

    public List<Object> findAll(){
        return mongoTemplate.findAll(Object.class);
    }

    public List<MongoBean> findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.find(query, MongoBean.class);
    }

}
