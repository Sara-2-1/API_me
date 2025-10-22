package pojos.random_user;

public class Coordinates{
	private String latitude;
	private String longitude;

	public String getLatitude(){
		return latitude;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"Coordinates{" + 
			"latitude = '" + latitude + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}
