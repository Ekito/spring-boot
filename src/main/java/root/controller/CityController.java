package root.controller;

import org.springframework.boot.SpringApplication;
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
	
	public static void main(String[] args) throws Exception {
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        System.setProperty("server.port", webPort);
        SpringApplication.run(CityController.class, args);
    }


}
