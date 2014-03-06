//package root.domain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection="cities")
//public class City {
//	
//	@Id
//	private String id;
//	
//	private String city;
//	
//	private List<Float> loc = new ArrayList<Float>();
//	
//	private int pop;
//
//	public City(String city, List<Float> loc, int pop) {
//		super();
//		this.city = city;
//		this.loc = loc;
//		this.pop = pop;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public List<Float> getLoc() {
//		return loc;
//	}
//
//	public void setLoc(List<Float> loc) {
//		this.loc = loc;
//	}
//
//	public int getPop() {
//		return pop;
//	}
//
//	public void setPop(int pop) {
//		this.pop = pop;
//	}
//
//	
//	
//	
//}
