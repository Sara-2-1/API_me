package pojos.random_user;

public class Registered{
	private String date;
	private Integer age;

	public String getDate(){
		return date;
	}

	public Integer getAge(){
		return age;
	}

	@Override
 	public String toString(){
		return 
			"Registered{" + 
			"date = '" + date + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}
