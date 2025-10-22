package pojos.random_user;

import java.util.List;

public class RandomUserPojo {
	private List<ResultsItem> results;
	private Info info;

	public List<ResultsItem> getResults(){
		return results;
	}

	public Info getInfo(){
		return info;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"results = '" + results + '\'' + 
			",info = '" + info + '\'' + 
			"}";
		}
}