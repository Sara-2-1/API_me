package pojos.random_user;

public class Picture{
	private String thumbnail;
	private String large;
	private String medium;

	public String getThumbnail(){
		return thumbnail;
	}

	public String getLarge(){
		return large;
	}

	public String getMedium(){
		return medium;
	}

	@Override
 	public String toString(){
		return 
			"Picture{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",large = '" + large + '\'' + 
			",medium = '" + medium + '\'' + 
			"}";
		}
}
