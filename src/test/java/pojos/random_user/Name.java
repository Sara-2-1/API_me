package pojos.random_user;

public class Name{
	private String last;
	private String title;
	private String first;

	public String getLast(){
		return last;
	}

	public String getTitle(){
		return title;
	}

	public String getFirst(){
		return first;
	}

	@Override
 	public String toString(){
		return 
			"Name{" + 
			"last = '" + last + '\'' + 
			",title = '" + title + '\'' + 
			",first = '" + first + '\'' + 
			"}";
		}
}
