package by.bsuir.timetable.rest;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "timetable";
    }

    @Override
    public MongoClient mongo() throws Exception {
        MongoClient mongoClient = new MongoClient();
        mongoClient.setWriteConcern(WriteConcern.SAFE);

        return mongoClient;
    }
}
