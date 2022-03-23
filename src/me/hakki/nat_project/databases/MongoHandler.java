package me.hakki.nat_project.databases;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import me.hakki.nat_project.api.databases.IDatabaseHandler;
import me.hakki.nat_project.objects.Kullanici;
import org.bson.Document;

public class MongoHandler implements IDatabaseHandler {
    private MongoClient client;
    public MongoHandler(){
        //client and hlZsinYfYNN6Q5It

        ConnectionString connectionString = new ConnectionString(System.getenv("CONNECTION_STRING"));
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        client = MongoClients.create(settings);
    }

    @Override
    public Kullanici girisYap(String kullaniciAdi, String sifre) {
        if(client == null) return null;
        BasicDBObject query = new BasicDBObject();
        query.put("username", kullaniciAdi);
        FindIterable<Document> response = client.getDatabase("nat_project").getCollection("users").find(query);
        if(!response.iterator().hasNext()) return null;
        Document userDocument = response.iterator().next();
        return new Kullanici(userDocument.getString("username"), null);
    }
}
