package pojos.random_user;

public class Street{
	private Integer number;
	private String name;

	public Integer getNumber(){
		return number;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Street{" + 
			"number = '" + number + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}
