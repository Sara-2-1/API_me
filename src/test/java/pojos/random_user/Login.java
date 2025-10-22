package pojos.random_user;

public class Login{
	private String sha1;
	private String password;
	private String salt;
	private String sha256;
	private String uuid;
	private String username;
	private String md5;

	public String getSha1(){
		return sha1;
	}

	public String getPassword(){
		return password;
	}

	public String getSalt(){
		return salt;
	}

	public String getSha256(){
		return sha256;
	}

	public String getUuid(){
		return uuid;
	}

	public String getUsername(){
		return username;
	}

	public String getMd5(){
		return md5;
	}

	@Override
 	public String toString(){
		return 
			"Login{" + 
			"sha1 = '" + sha1 + '\'' + 
			",password = '" + password + '\'' + 
			",salt = '" + salt + '\'' + 
			",sha256 = '" + sha256 + '\'' + 
			",uuid = '" + uuid + '\'' + 
			",username = '" + username + '\'' + 
			",md5 = '" + md5 + '\'' + 
			"}";
		}
}
