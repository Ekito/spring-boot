package root.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import root.domain.City;

public class CityRepositoryImpl implements CityRepositoryCustom {

	@Autowired
	public MongoTemplate mongoTemplate;

	public List<City> findCityLike(String name) {
		List<City> cities = new ArrayList<City>();

		Query query = new Query();
		query.addCriteria(Criteria.where("city").regex(name, "i"));
		query.limit(500);

		cities = mongoTemplate.find(query, City.class);

		return cities;
	}
}
