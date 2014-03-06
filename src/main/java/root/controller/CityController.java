package root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CityController {
	
//	@Autowired
//	private CityRepository cityRepo;
	
	@RequestMapping(value = "/v1/springboot/city/{name}", method = RequestMethod.GET)
	public @ResponseBody
	String findCitiesByName(@PathVariable("name") String name) {
		
		
		
		return "yes!!!";
	}


}
