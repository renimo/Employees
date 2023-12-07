//package com.employees_DB;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
//
////@Configuration
////public class MongoConfig {
////    private final String MONGO_DB_URL = "mongodb+srv://renimo:employees@employees.ubjilos.mongodb.net/?retryWrites=true&w=majority"; // Update with your MongoDB connection URL
////    private final String MONGO_DB_NAME = "Employees"; // Update with your MongoDB database name
////
////    @Bean
////    public MongoTemplate mongoTemplate() {
////        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MONGO_DB_URL, MONGO_DB_NAME));
////    }
////}
//
//@Configuration
//public class MongoConfig extends AbstractMongoClientConfiguration {
//
//    @Value("${spring.data.mongodb.uri}")
//    private String uri;
//
//    @Value("${spring.data.mongodb.database}")
//    private String databaseName;
//
//    @Bean
//    public MongoClient mongo() {
//        return MongoClients.create(uri);
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return databaseName;
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongo(), getDatabaseName());
//    }
//}
