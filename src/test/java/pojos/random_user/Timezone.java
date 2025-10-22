package pojos.random_user;

public class Timezone{
	private String offset;
	private String description;

	public String getOffset(){
		return offset;
	}

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"Timezone{" + 
			"offset = '" + offset + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}
