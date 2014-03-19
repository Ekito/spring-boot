package root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import root.domain.City;
import root.repository.CityRepository;

@Controller
public class CityController {
	
	@Autowired
	private CityRepository cityRepo;
	
	@RequestMapping(value = "/v1/springboot/city/{name}", method = RequestMethod.GET)
	public @ResponseBody
	List<City> findCitiesByName(@PathVariable("name") String name) {
		
		return cityRepo.findCityLike(name);
	}
}
