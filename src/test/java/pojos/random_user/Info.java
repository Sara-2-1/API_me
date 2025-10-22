package pojos.random_user;

public class Info{
	private String seed;
	private Integer page;
	private Integer results;
	private String version;

	public String getSeed(){
		return seed;
	}

	public Integer getPage(){
		return page;
	}

	public Integer getResults(){
		return results;
	}

	public String getVersion(){
		return version;
	}

	@Override
 	public String toString(){
		return 
			"Info{" + 
			"seed = '" + seed + '\'' + 
			",page = '" + page + '\'' + 
			",results = '" + results + '\'' + 
			",version = '" + version + '\'' + 
			"}";
		}
}
