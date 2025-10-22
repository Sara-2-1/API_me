package pojos.random_user;

public class Dob{
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
			"Dob{" + 
			"date = '" + date + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}
