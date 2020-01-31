package stanic.zclojas.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Collections;

public class MongoDB {

    private MongoClient client;

    public Boolean exists() {
        return getDatabase().listCollectionNames().into(new ArrayList<>()).contains("shops");
    }

    public void start() {
        client = MongoClients.create(
                MongoClientSettings.builder().applyToClusterSettings(it ->
                        it.hosts(Collections.singletonList(new ServerAddress("localhost", 27017))))
                        .build()
        );

        if (!exists()) getDatabase().createCollection("shops");
    }

    public MongoDatabase getDatabase() {
        return client.getDatabase("shops");
    }

}