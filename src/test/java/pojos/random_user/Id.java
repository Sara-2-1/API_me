package pojos.random_user;

public class Id{
	private String name;
	private String value;

	public String getName(){
		return name;
	}

	public String getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Id{" + 
			"name = '" + name + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}
