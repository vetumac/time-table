package by.bsuir.timetable.rest;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {

    @Value(value = "${spring.data.mongodb.uri}")
    private String uri;

    @Override
    protected String getDatabaseName() {
        return "time-table";
    }

    @Override
    public MongoClient mongo() throws Exception {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));
        mongoClient.setWriteConcern(WriteConcern.SAFE);

        return mongoClient;
    }
}
