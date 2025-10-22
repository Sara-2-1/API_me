package pojos.random_user;

public class Location{
	private String country;
	private String city;
	private Street street;
	private Timezone timezone;
	private Integer postcode;
	private Coordinates coordinates;
	private String state;

	public String getCountry(){
		return country;
	}

	public String getCity(){
		return city;
	}

	public Street getStreet(){
		return street;
	}

	public Timezone getTimezone(){
		return timezone;
	}

	public Integer getPostcode(){
		return postcode;
	}

	public Coordinates getCoordinates(){
		return coordinates;
	}

	public String getState(){
		return state;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"country = '" + country + '\'' + 
			",city = '" + city + '\'' + 
			",street = '" + street + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",postcode = '" + postcode + '\'' + 
			",coordinates = '" + coordinates + '\'' + 
			",state = '" + state + '\'' + 
			"}";
		}
}
