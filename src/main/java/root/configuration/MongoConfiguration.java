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
	  UserCredentials userCredentials = new UserCredentials("dimitri", "let'srock69");

//	  Mongo mongoClient = new MongoClient(
//			    new ServerAddress("ds031319.mongolab.com", 31319)); 
	  
	  Mongo mongoClient = new MongoClient(
			    new ServerAddress("localhost", 27017)); 
	  
//    return new SimpleMongoDbFactory(mongoClient, "heroku_app22732496", userCredentials);
	  return new SimpleMongoDbFactory(mongoClient, "uspopulation");
  }

  public @Bean MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongoDbFactory());
  }
}
