package root.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import root.domain.City;

public interface CityRepository extends MongoRepository<City, String>, CityRepositoryCustom{
	

}
