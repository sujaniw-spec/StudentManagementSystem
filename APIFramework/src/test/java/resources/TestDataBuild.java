package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	
	public AddPlace addPlacePayload(String name, String language, String address) {
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);		
		p.setName(name);
		p.setAddress(address);
		p.setLanguage(language);
		p.setWebsite("http://google.com");
		p.setPhone_number("(+1) 9835 893 3937");
		List<String> typeList = new ArrayList<String>();
		typeList.add("shoe park");
		typeList.add("shoe");		
		p.setTypes(typeList);
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		p.setLocation(location);	
		return p;
	}
	
	public String deletePlacePayLoad(String placeId) {
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
}
