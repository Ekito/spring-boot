package root.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


@Configuration
public class MongoConfiguration {
  
  public @Bean MongoDbFactory mongoDbFactory() throws Exception {
	  UserCredentials userCredentials = new UserCredentials("dimitri", "dimitri31");

	  Mongo mongoClient = new MongoClient(
			    new ServerAddress("localhost", 31319)); 
	  
    return new SimpleMongoDbFactory(mongoClient, "heroku_app22732496", userCredentials);
  }

  public @Bean MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongoDbFactory());
  }
}
