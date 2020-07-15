package com.example.demo.controller;

import com.example.demo.dao.MongoDao;
import com.example.demo.entity.MongoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private MongoDao mongoDao;

    @GetMapping("/add")
    @ResponseBody
    public void add(){
        MongoBean mongoBean = new MongoBean();
        mongoBean.setName("clg");
        mongoBean.setId(new Date().getTime());
        mongoBean.setAge(22);
        mongoDao.savMongo(mongoBean);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<MongoBean> findList(){
        return mongoDao.findList();
    }

    @GetMapping("/byname")
    @ResponseBody
    public List<MongoBean> findByName(String name){
        return mongoDao.findByName(name);
    }

}
