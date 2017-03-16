//package com.findgods.fly.config;
//
//import com.mongodb.MongoClient;
//import org.mongodb.morphia.Datastore;
//import org.mongodb.morphia.Morphia;
//import org.mongodb.morphia.annotations.Entity;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.type.filter.AnnotationTypeFilter;
//
//import javax.annotation.Resource;
//
///**
// * REVIEW
// * @Description:
// * @author xiaoxu.huang@baidao.com xiaoxu.huang
// * @date 2017/3/16  18:26
// *
// */
//@Configuration
//public class MorphiaAutoConfiguration {
//	@Resource
//	private MongoClient mongoClient; // created from MongoAutoConfiguration
//
//	@Bean
//	public Datastore datastore() {
//		Morphia morphia = new Morphia();
//
//		// map entities, there is maybe a better way to find and map all entities
//		ClassPathScanningCandidateComponentProvider entityScanner = new ClassPathScanningCandidateComponentProvider(true);
//		entityScanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
//		for (BeanDefinition candidate : scanner.findCandidateComponents("your.basepackage")) { // from properties?
//			morphia.map(Class.forName(candidate.getBeanClassName()));
//		}
//
//		return morphia.createDatastore(mongoClient, "dataStoreInstanceId"); // "dataStoreInstanceId" may come from properties?
//	}
//
//
//
//}
