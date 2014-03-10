package root.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;


@Configuration
public class MongoConfiguration {
  
  public @Bean MongoDbFactory mongoDbFactory() throws Exception {
	  UserCredentials userCredentials = new UserCredentials("heroku_app22732496", "heroku_app22732496");
    return new SimpleMongoDbFactory(new MongoClient(), "heroku_app22732496", userCredentials);
  }

  public @Bean MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongoDbFactory());
  }
}
