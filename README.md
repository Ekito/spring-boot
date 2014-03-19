spring-boot
===========

A simple rest service with Spring boot



Je vous propose une série de tutos sur comment développer un service REST avec différentes technologies telle que Spring Boot, Play!, Node.js ou bien Rails.

Le service interrogera une base MongoDB et sera hébergé sur Heroku.

La première partie de cette série est consacré à Spring boot.

spring-boot

Spring boot est une des réponses de Spring aux frameworks de developpement web que sont Play ! ou bien Ruby on Rails.

Ici plus de fichiers de configuration, ils sont remplacer par de la convention !

L'application peut être créé en ligne de commande et lancé en standalone (tomcat embarqué ou netty).

Elle embarque maven et un pom.xml allégé.

 

Pour le développement de l'application j'ai décidé de passer par l'IDE Spring tool suite.

Voici les différentes étapes de la construction et du déploiement du service.

Création du projet via le wizard spring starter project de spring.
newspringstarterproject

Voilà le projet est créé, vous noterez (cf. source) qu'il n'y a plus de fichier de configuration. Spring va scanner tout ce qui se trouve dans le dossier "root".

Classe de configuration de MongoDB
@Configuration
 public class MongoConfiguration {

 public @Bean MongoDbFactory mongoDbFactory() throws Exception {
    // login et mot de passe de la base de données
    UserCredentials userCredentials = new UserCredentials("dimitri", "let'srock69");
    Mongo mongoClient = new MongoClient(
       // adresse et port de la base de données
       new ServerAddress("ds031319.mongolab.com", 31319));
    // nom de la table
    return new SimpleMongoDbFactory(mongoClient, "heroku_app22732496", userCredentials);
 }
public @Bean MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongoDbFactory());
  }
 }
 Mapping de la collection Mongo avec l'objet Java
// nom de la collection si elle est différente du nom de la classe
@Document(collection="cities")
public class City {

 @Id
 private String id;

 private String city;

 private List<Float> loc = new ArrayList<Float>();

 private int pop; 
 public City(String city, List<Float> loc, int pop) {
  super();
  this.city = city;
  this.loc = loc;
  this.pop = pop;
 }
Création d'un repository custom.
public interface CityRepository extends MongoRepository<City, String>, CityRepositoryCustom{
  public List<City> findByCity(String city);
}
 public interface CityRepositoryCustom {
  public List<City> findCityLike(String name);
 }
public class CityRepositoryImpl implements CityRepositoryCustom {
 @Autowired
 public MongoTemplate mongoTemplate;
 
 public List<City> findCityLike(String name) {
  List<City> cities = new ArrayList<City>();
  Query query = new Query();
  // "i" pour case insensitive
  query.addCriteria(Criteria.where("city").regex(name, "i"));
  query.limit(500);
  cities = mongoTemplate.find(query, City.class);
  return cities;
 }
}
Ici j'étends le MongoRepository fourni par spring data pour écrire une méthode de recherche custo, un "findLike".

Création du controler Spring
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
On rajoute un fichier Procfile ainsi qu'une petite méthode de configuration du port de tomcat pour le déploiement sur Heroku
web: java $JAVA_OPTS -jar target/*.jar --p $PORT
@ComponentScan
@EnableAutoConfiguration
 public class Application {
   public static void main(String[] args) throws Exception {
     // le port sur heroku est aléaoire !
     String webPort = System.getenv("PORT");
     if (webPort == null || webPort.isEmpty()) {
       webPort = "8080";
     }
     System.setProperty("server.port", webPort);
     SpringApplication.run(Application.class, args);
  }
 }
Un petit push sur Heroku et Voilà !
http://springboot.herokuapp.com/v1/springboot/city/dim

 
