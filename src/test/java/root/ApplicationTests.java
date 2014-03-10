package root;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import root.domain.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader=SpringApplicationContextLoader.class)
public class ApplicationTests {	
	
	@Autowired
	public MongoTemplate mongoTemplate;

	@Test
	public void contextLoads() {
		
		List<City> cities = new ArrayList<City>();

		Query query = new Query();
		query.addCriteria(Criteria.where("city").regex("a", "i"));
		query.limit(500);

		cities = mongoTemplate.find(query, City.class);

		Assert.assertTrue("Mongo is not plugged !", cities.size() > 0);
	}

}
