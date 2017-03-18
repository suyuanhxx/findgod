//package com.findgods.fly.config;
//
//
//import com.mongodb.MongoClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//
///**
// * REVIEW
// *
// * @author xiaoxu.huang@baidao.com xiaoxu.huang
// * @Description:
// * @date 2017/3/16  18:26
// */
//@Configuration
//public class MongoConfiguration {
//
//    @Bean
//    public MongoDbFactory mongoDbFactory() throws Exception {
//        return new SimpleMongoDbFactory(new MongoClient(), "myDatabase");
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//        return mongoTemplate;
//    }
//
//    @Bean
//    public MongoOperations mongoOperations() throws Exception {
//        return mongoTemplate();
//    }
//}
