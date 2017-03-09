package com.findgods.freedom.mongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

/**
 * REVIEW
 * @Description:
 * @author xiaoxu.huang
 * @date 2017/3/7  17:19
 *
 */
@Configuration
public class DatabaseConfiguration {

	private static final String host = "127.0.0.1";
	private static final String port = "27017";
	private static final String dbname = "morphiaTest";

	@Bean
	public MongoClient mongoClient() throws UnknownHostException {
		return (new MongoClient(host + ":" + port));
	}

	@Bean
	public Datastore datastore() throws UnknownHostException {
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.hackinghorse.morphiamongoexample.model");
		Datastore datastore = morphia.createDatastore(mongoClient(), dbname);
		datastore.ensureIndexes();
		return datastore;
	}

	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException {
		return new SimpleMongoDbFactory(mongoClient(), dbname);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}

}
