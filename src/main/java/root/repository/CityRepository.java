package root.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import root.domain.City;

public interface CityRepository extends MongoRepository<City, String>, CityRepositoryCustom{
	
	public List<City> findByCity(String city);

}
